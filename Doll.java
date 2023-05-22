public class Doll extends Toy {
    private String material;

    public Doll(String name, int size, double price, String material) {
        super(name, size, price);
        this.material = material;
    }

    // Getters and setters

    @Override
    public String toString() {
        return "Doll: " + super.toString() + ", Material: " + material;
    }
}