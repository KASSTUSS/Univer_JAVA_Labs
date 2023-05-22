import java.io.Serializable;
import exception.InvalidFieldValueException;

public class Person implements Serializable {
    private String lastName;
    private int age;
    private String gender;

    public Person(String lastName, int age, String gender) throws InvalidFieldValueException {
        if (age < 0) {
            throw new InvalidFieldValueException("Invalid age: " + age);
        }

        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    // Other methods

    @Override
    public String toString() {
        return "Person{" +
                "lastName='" + lastName + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}