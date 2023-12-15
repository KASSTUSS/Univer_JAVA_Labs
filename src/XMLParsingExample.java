import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

class Article {
    private String title;
    private String link;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}

class ArticleHandler extends DefaultHandler {
    private List<Article> articles;
    private Article currentArticle;
    private StringBuilder data;

    public ArticleHandler() {
        articles = new ArrayList<>();
    }

    public List<Article> getArticles() {
        return articles;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("item")) {
            currentArticle = new Article();
        }
        data = new StringBuilder();
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (currentArticle != null) {
            if (qName.equalsIgnoreCase("title")) {
                currentArticle.setTitle(data.toString());
            } else if (qName.equalsIgnoreCase("link")) {
                currentArticle.setLink(data.toString());
            } else if (qName.equalsIgnoreCase("item")) {
                if (currentArticle.getTitle() != null && !currentArticle.getTitle().isEmpty() &&
                        currentArticle.getLink() != null && !currentArticle.getLink().isEmpty()) {
                    articles.add(currentArticle);
                }
                currentArticle = null;
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        data.append(new String(ch, start, length));
    }
}

public class XMLParsingExample {
    public static void main(String[] args) {
        String url = "https://www.politico.com/rss/politicopicks.xml";

        // DOM parsing
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new URL(url).openStream());
            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("item");
            List<Article> articlesDOM = new ArrayList<>();

            for (int temp = 0; temp < nodeList.getLength(); temp++) {
                Element element = (Element) nodeList.item(temp);
                Article article = new Article();
                article.setTitle(getTagValue("title", element));
                article.setLink(getTagValue("link", element));
                articlesDOM.add(article);
            }

            System.out.println("Articles (DOM):");
            for (Article article : articlesDOM) {
                System.out.println(article.getTitle() + " - " + article.getLink());
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }

        // SAX parsing
        try {
            SAXParserFactory spf = SAXParserFactory.newInstance();
            SAXParser sp = spf.newSAXParser();
            ArticleHandler handler = new ArticleHandler();
            InputStream inputStream = new URL(url).openStream();
            sp.parse(inputStream, handler);
            List<Article> articlesSAX = handler.getArticles();

            System.out.println("Articles (SAX):");
            for (Article article : articlesSAX) {
                System.out.println(article.getTitle() + " - " + article.getLink());
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }

        // StAX parsing
        try {
            XMLInputFactory xif = XMLInputFactory.newFactory();
            XMLStreamReader reader = xif.createXMLStreamReader(new URL(url).openStream());

            List<Article> articlesStAX = new ArrayList<>();
            Article currentArticle = null;
            String elementName = "";
            StringBuilder data = new StringBuilder();

            while (reader.hasNext()) {
                int event = reader.next();

                switch (event) {
                    case XMLStreamConstants.START_ELEMENT:
                        elementName = reader.getLocalName();
                        if (elementName.equalsIgnoreCase("item")) {
                            currentArticle = new Article();
                        } else if (currentArticle != null) {
                            data = new StringBuilder();
                        }
                        break;

                    case XMLStreamConstants.CHARACTERS:
                        if (currentArticle != null) {
                            data.append(reader.getText());
                        }
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        elementName = reader.getLocalName();
                        if (elementName.equalsIgnoreCase("title") && currentArticle != null) {
                            currentArticle.setTitle(data.toString());
                        } else if (elementName.equalsIgnoreCase("link") && currentArticle != null) {
                            currentArticle.setLink(data.toString());
                        } else if (elementName.equalsIgnoreCase("item") && currentArticle != null) {
                            articlesStAX.add(currentArticle);
                            currentArticle = null;
                        }
                        break;
                }
            }

            System.out.println("\nArticles (StAX):");
            for (Article article : articlesStAX) {
                System.out.println(article.getTitle() + " - " + article.getLink());
            }
        } catch (XMLStreamException | IOException e) {
            e.printStackTrace();
        }
    }

    private static String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        return nodeList.item(0).getNodeValue();
    }
}