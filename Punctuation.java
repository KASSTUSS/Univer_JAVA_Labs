public class Punctuation implements Lexeme {
    private String value;

    public Punctuation(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}