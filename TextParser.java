import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextParser {
    private static final String PARAGRAPH_REGEX = "(?m)(?=^\\S)";
    private static final String SENTENCE_REGEX = "([^.!?]+[.!?]+\\s*)";
    private static final String LEXEME_REGEX = "([\\w-]+|\\p{Punct})";

    public void parse(String text) {
        String[] paragraphs = text.split(PARAGRAPH_REGEX);
        for (String paragraph : paragraphs) {
            Paragraph parsedParagraph = parseParagraph(paragraph);
            System.out.println(parsedParagraph);
        }
    }

    private Paragraph parseParagraph(String paragraph) {
        Paragraph parsedParagraph = new Paragraph();

        Pattern sentencePattern = Pattern.compile(SENTENCE_REGEX);
        Matcher sentenceMatcher = sentencePattern.matcher(paragraph);
        while (sentenceMatcher.find()) {
            String sentence = sentenceMatcher.group();
            Sentence parsedSentence = parseSentence(sentence);
            parsedParagraph.addSentence(parsedSentence);
        }

        return parsedParagraph;
    }

    private Sentence parseSentence(String sentence) {
        Sentence parsedSentence = new Sentence();

        Pattern lexemePattern = Pattern.compile(LEXEME_REGEX);
        Matcher lexemeMatcher = lexemePattern.matcher(sentence);
        while (lexemeMatcher.find()) {
            String lexeme = lexemeMatcher.group();
            Lexeme parsedLexeme = parseLexeme(lexeme);
            parsedSentence.addLexeme(parsedLexeme);
        }

        return parsedSentence;
    }

    private Lexeme parseLexeme(String lexeme) {
        if (lexeme.matches("\\p{Punct}")) {
            return new Punctuation(lexeme);
        } else {
            return new Word(lexeme);
        }
    }
}