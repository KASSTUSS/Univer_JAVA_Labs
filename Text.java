import java.util.ArrayList;
import java.util.List;

public class Text {
    private List<Paragraph> paragraphs;

    public Text() {
        paragraphs = new ArrayList<>();
    }

    public void addParagraph(Paragraph paragraph) {
        paragraphs.add(paragraph);
    }

    public List<Paragraph> getParagraphs() {
        return paragraphs;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Paragraph paragraph : paragraphs) {
            sb.append(paragraph);
            sb.append("\n\n");
        }
        return sb.toString();
    }
}