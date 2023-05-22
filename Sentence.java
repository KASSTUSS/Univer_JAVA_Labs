import java.util.ArrayList;
import java.util.List;

public class Sentence {
    private List<Lexeme> lexemes;

    public Sentence() {
        lexemes = new ArrayList<>();
    }

    public void addLexeme(Lexeme lexeme) {
        lexemes.add(lexeme);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Lexeme lexeme : lexemes) {
            sb.append(lexeme);
        }
        return sb.toString();
    }
}