public class Person {
    private String lastName;
    private int age;
    private String gender;

    public Person(String lastName, int age, String gender) {
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
}
