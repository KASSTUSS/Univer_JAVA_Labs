import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        Person[] persons = new Person[10];

        // Creating objects using different constructors
        persons[0] = new Person("Smith", 25, "Male");
        persons[1] = new Person("Johnson", 30, "Female");
        persons[2] = new Person("Williams", 42, "Male");
        persons[3] = null; // Null object
        persons[4] = new Person("Brown", 35, "Female");
        persons[5] = new Person("Miller", 50, "Male");
        persons[6] = new Person("Davis", 28, "Female");
        persons[7] = new Person("Anderson", 38, "Male");
        persons[8] = new Person("Wilson", 29, "Female");
        persons[9] = new Person("Taylor", 32, "Male");

        // Sort the array by age in ascending order
        Arrays.sort(persons, (p1, p2) -> {
            if (p1 == null) {
                return 1;
            } else if (p2 == null) {
                return -1;
            } else {
                return Integer.compare(p1.getAge(), p2.getAge());
            }
        });

        // Output the sorted array
        System.out.println("Sorted Array:");
        for (Person person : persons) {
            if (person != null) {
                System.out.println("Last Name: " + person.getLastName() + ", Age: " + person.getAge() + ", Gender: " + person.getGender());
            } else {
                System.out.println("Null Object");
            }
        }

        // Calculate average age and number of men
        int totalAge = 0;
        int maleCount = 0;

        for (Person person : persons) {
            if (person != null) {
                totalAge += person.getAge();
                if (person.getGender().equals("Male")) {
                    maleCount++;
                }
            }
        }

        double averageAge = totalAge / (double) (persons.length - 1); // Exclude the null object from count

        System.out.println("Average Age: " + averageAge);
        System.out.println("Number of Men: " + maleCount);

        // Output the sorted array two more times
        System.out.println("\nSorted Array (2nd time):");
        for (Person person : persons) {
            if (person != null) {
                System.out.println("Last Name: " + person.getLastName() + ", Age: " + person.getAge() + ", Gender: " + person.getGender());
            } else {
                System.out.println("Null Object");
            }
        }

        System.out.println("\nSorted Array (3rd time):");
        for (Person person : persons) {
            if (person != null) {
                System.out.println("Last Name: " + person.getLastName() + ", Age: " + person.getAge() + ", Gender: " + person.getGender());
            } else {
                System.out.println("Null Object");
            }
        }
    }
}
