public class Ball extends Toy {
    private String color;

    public Ball(String name, int size, double price, String color) {
        super(name, size, price);
        this.color = color;
    }

    // Getters and setters

    @Override
    public String toString() {
        return "Ball: " + super.toString() + ", Color: " + color;
    }
}