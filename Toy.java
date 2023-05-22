public class Toy {
    private String name;
    private int size;
    private double price;

    public Toy(String name, int size, double price) {
        this.name = name;
        this.size = size;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }

    // Setters and other methods

    @Override
    public String toString() {
        return "Toy: " + name + ", Size: " + size + ", Price: " + price;
    }
}