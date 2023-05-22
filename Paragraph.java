import java.util.ArrayList;
import java.util.List;

public class Paragraph {
    private List<Sentence> sentences;

    public Paragraph() {
        sentences = new ArrayList<>();
    }

    public void addSentence(Sentence sentence) {
        sentences.add(sentence);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Sentence sentence : sentences) {
            sb.append(sentence).append(" ");
        }
        return sb.toString().trim();
    }
}