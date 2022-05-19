package ru.java.hse.sd.controller;

public class Checker {
    private final String id;
    private final String code;

    public Checker(String id, String code) {
        this.id = id;
        this.code = code;
    }

    public String getId() {
        return id;
    }

    public String getCode() {
        return code;
    }
}
