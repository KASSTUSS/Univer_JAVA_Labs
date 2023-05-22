public class Cube extends Toy {
    private String shape;

    public Cube(String name, int size, double price, String shape) {
        super(name, size, price);
        this.shape = shape;
    }

    // Getters and setters

    @Override
    public String toString() {
        return "Cube: " + super.toString() + ", Shape: " + shape;
    }
}