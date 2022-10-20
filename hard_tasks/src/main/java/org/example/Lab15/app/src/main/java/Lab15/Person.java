package Lab15;

import java.io.Serializable;

public class Person implements Serializable {
    private String firstName;
    private String secondName;
    private int age;

    private static final long serialVersionUID = -3722203743604454371L;
    public String getFirstName() {
        return firstName;
    }
    public String getSecondName() {
        return secondName;
    }
    public int getAge() {
        return age;
    }
    public Person(String firstName, String secondName, int age) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
    }

    public String toString() {
        return "Name: " + getFirstName() + "\n" +
                "SecondName: " + getSecondName() + "\n" +
                "Age: " + getAge();
    }
}
