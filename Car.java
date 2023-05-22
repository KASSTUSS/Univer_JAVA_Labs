public class Car extends Toy {
    private String type;

    public Car(String name, int size, double price, String type) {
        super(name, size, price);
        this.type = type;
    }

    // Getters and setters

    @Override
    public String toString() {
        return "Car: " + super.toString() + ", Type: " + type;
    }
}