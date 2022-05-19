package ru.java.hse.sd.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;

public class Task {
    private final String id;
    private final String name;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss[.SSS]")
    private final LocalDateTime publicationDate;
    private final String taskDescription;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss[.SSS]")
    private final LocalDateTime deadline;
    private final String checkerId;

    public Task(String id, String name, LocalDateTime publicationDate,
        String taskDescription, LocalDateTime deadline, String checkerId) {
        this.id = id;
        this.name = name;
        this.publicationDate = publicationDate;
        this.taskDescription = taskDescription;
        this.deadline = deadline;
        this.checkerId = checkerId;
    }

    public String id() {
        return id;
    }

    public String name() {
        return name;
    }

    public LocalDateTime publicationDate() {
        return publicationDate;
    }

    public String taskDescription() {
        return taskDescription;
    }

    public LocalDateTime deadline() {
        return deadline;
    }

    public String getCheckerId() {
        return checkerId;
    }
}
