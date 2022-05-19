package ru.java.hse.sd.model.view;

public class StudentView {
    private final String name;
    private final String lastName;

    public StudentView(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public String name() {
        return name;
    }

    public String lastName() {
        return lastName;
    }
}
