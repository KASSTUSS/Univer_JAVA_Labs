import java.util.Arrays;

public class ToyRoom {
    private Toy[] toys;
    private int count;

    public ToyRoom(int capacity) {
        toys = new Toy[capacity];
        count = 0;
    }

    public void addToy(Toy toy) {
        if (count < toys.length) {
            toys[count] = toy;
            count++;
            System.out.println("Toy added successfully.");
        } else {
            System.out.println("Toy room is full. Cannot add more toys.");
        }
    }

    public void sortByParameter(String parameter) {
        switch (parameter.toLowerCase()) {
            case "name":
                Arrays.sort(toys, 0, count, (t1, t2) -> t1.getName().compareTo(t2.getName()));
                break;
            case "size":
                Arrays.sort(toys, 0, count, (t1, t2) -> Integer.compare(t1.getSize(), t2.getSize()));
                break;
            case "price":
                Arrays.sort(toys, 0, count, (t1, t2) -> Double.compare(t1.getPrice(), t2.getPrice()));
                break;
            default:
                System.out.println("Invalid parameter for sorting.");
                return;
        }

        System.out.println("Toys sorted by " + parameter + ".");
        displayToys();
    }

    public void findToysInRange(int minSize, int maxSize) {
        System.out.println("Toys within the size range of " + minSize + " to " + maxSize + ":");

        for (int i = 0; i < count; i++) {
            if (toys[i].getSize() >= minSize && toys[i].getSize() <= maxSize) {
                System.out.println(toys[i]);
            }
        }
    }

    private void displayToys() {
        System.out.println("Toys in the toy room:");

        for (int i = 0; i < count; i++) {
            System.out.println(toys[i]);
        }
    }
}