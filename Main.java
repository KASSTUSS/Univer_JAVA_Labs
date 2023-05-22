import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ToyRoom toyRoom = new ToyRoom(10);

        boolean exit = false;
        while (!exit) {
            System.out.println("\n--- Game Room Menu ---");
            System.out.println("1. Add Toy");
            System.out.println("2. Sort Toys");
            System.out.println("3. Find Toys in Range");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addToy(scanner, toyRoom);
                    break;
                case 2:
                    sortToys(scanner, toyRoom);
                    break;
                case 3:
                    findToysInRange(scanner, toyRoom);
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        System.out.println("Exiting the Game Room.");
    }

    private static void addToy(Scanner scanner, ToyRoom toyRoom) {
        System.out.print("Enter the toy type (car, doll, ball, cube): ");
        String type = scanner.next().toLowerCase();

        System.out.print("Enter the toy name: ");
        String name = scanner.next();

        System.out.print("Enter the toy size: ");
        int size = scanner.nextInt();

        System.out.print("Enter the toy price: ");
        double price = scanner.nextDouble();

        switch (type) {
            case "car":
                System.out.print("Enter the car type (small, medium, large): ");
                String carType = scanner.next().toLowerCase();
                Car car = new Car(name, size, price, carType);
                toyRoom.addToy(car);
                break;
            case "doll":
                System.out.print("Enter the doll material (plastic, cloth): ");
                String dollMaterial = scanner.next().toLowerCase();
                Doll doll = new Doll(name, size, price, dollMaterial);
                toyRoom.addToy(doll);
                break;
            case "ball":
                System.out.print("Enter the ball color: ");
                String ballColor = scanner.next();
                Ball ball = new Ball(name, size, price, ballColor);
                toyRoom.addToy(ball);
                break;
            case "cube":
                System.out.print("Enter the cube shape (square, rectangular): ");
                String cubeShape = scanner.next().toLowerCase();
                Cube cube = new Cube(name, size, price, cubeShape);
                toyRoom.addToy(cube);
                break;
            default:
                System.out.println("Invalid toy type.");
                break;
        }
    }

    private static void sortToys(Scanner scanner, ToyRoom toyRoom) {
        System.out.print("Enter the parameter to sort by (name, size, price): ");
        String parameter = scanner.next().toLowerCase();
        toyRoom.sortByParameter(parameter);
    }

    private static void findToysInRange(Scanner scanner, ToyRoom toyRoom) {
        System.out.print("Enter the minimum size: ");
        int minSize = scanner.nextInt();

        System.out.print("Enter the maximum size: ");
        int maxSize = scanner.nextInt();

        toyRoom.findToysInRange(minSize, maxSize);
    }
}