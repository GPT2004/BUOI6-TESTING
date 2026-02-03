package bai2;

public class Person {
    private final String name;
    private final int age;

    public Person(String name, int age) {
        this.name = name;
        if (age < 0) {
            throw new IllegalArgumentException("Invalid age: " + age);
        }
        this.age = age;
    }
}