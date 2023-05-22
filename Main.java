import java.util.Arrays;
import java.util.Scanner;
import exception.FileAccessException;
import exception.InsufficientMemoryException;
import exception.InvalidFieldValueException;

public class Main {
    private static final String FILE_NAME = "persons.dat";

    public static void main(String[] args) {
        try {
            Person[] persons = readPersonsFromUser();
            savePersonsToFile(persons, FILE_NAME);
            Person[] loadedPersons = loadPersonsFromFile(FILE_NAME);
            displayPersonInfo(loadedPersons);
            calculateAverageAge(loadedPersons);
            calculateNumberOfMen(loadedPersons);
        } catch (FileAccessException | InvalidFieldValueException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static Person[] readPersonsFromUser() throws InvalidFieldValueException {
        Person[] persons = new Person[10];
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter information for 10 persons:");
        for (int i = 0; i < 10; i++) {
            System.out.println("Person #" + (i + 1));
            System.out.print("Last Name: ");
            String lastName = scanner.nextLine();
            System.out.print("Age: ");
            int age = scanner.nextInt();
            scanner.nextLine(); // Consume newline character
            System.out.print("Gender: ");
            String gender = scanner.nextLine();

            persons[i] = new Person(lastName, age, gender);
        }

        return persons;
    }

    private static void savePersonsToFile(Person[] persons, String fileName) throws FileAccessException {
        SerializationUtils.serialize(persons, fileName);
    }

    private static Person[] loadPersonsFromFile(String fileName) throws FileAccessException {
        Object object = SerializationUtils.deserialize(fileName);
        if (object instanceof Person[]) {
            return (Person[]) object;
        }
        return new Person[0];
    }

    private static void displayPersonInfo(Person[] persons) {
        System.out.println("Persons:");
        Arrays.stream(persons)
                .forEach(System.out::println);
    }

    private static void calculateAverageAge(Person[] persons) {
        int sum = Arrays.stream(persons)
                .mapToInt(Person::getAge)
                .sum();
        double averageAge = (double) sum / persons.length;
        System.out.println("Average Age: " + averageAge);
    }

    private static void calculateNumberOfMen(Person[] persons) {
        long numberOfMen = Arrays.stream(persons)
                .filter(person -> person.getGender().equalsIgnoreCase("male"))
                .count();
        System.out.println("Number of Men: " + numberOfMen);
    }
}