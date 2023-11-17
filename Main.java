import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество потоков: ");
        int numThreads = scanner.nextInt();

        System.out.print("Выберите операцию (1-сложение/2-вычитание/3-умножение): ");
        String operation = scanner.next();

        System.out.print("Введите нижнюю границу интервала: ");
        int lowerBound = scanner.nextInt();

        System.out.print("Введите верхнюю границу интервала: ");
        int upperBound = scanner.nextInt();

        ThreadGenerator threadGenerator = new ThreadGenerator(numThreads, operation, lowerBound, upperBound);

        try {
            threadGenerator.execute();
            System.out.println("Итоговый результат: " + threadGenerator.getResult());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}