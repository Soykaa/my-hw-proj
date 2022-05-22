package ru.java.hse.sd.controller;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

/**
 * Stores information about home task.
 **/
public class Task {
    private final String name;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss[.SSS]")
    private final LocalDateTime publicationDate;
    private final String taskDescription;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss[.SSS]")
    private final LocalDateTime deadline;
    private final String checkerId;

    /**
     * Creates new instance of Task object.
     * Initialises name, publicationDate, taskDescription, deadline and checkerId with the given values.
     *
     * @param name            homework name
     * @param publicationDate homework publication date
     * @param taskDescription task description
     * @param deadline        homework deadline
     * @param checkerId       checker id
     **/
    public Task(String name, LocalDateTime publicationDate,
                String taskDescription, LocalDateTime deadline, String checkerId) {
        this.name = name;
        this.publicationDate = publicationDate;
        this.taskDescription = taskDescription;
        this.deadline = deadline;
        this.checkerId = checkerId;
    }

    /**
     * Returns homework name.
     *
     * @return homework name as string
     **/
    public String name() {
        return name;
    }

    /**
     * Returns homework publication date.
     *
     * @return homework publication date
     **/
    public LocalDateTime publicationDate() {
        return publicationDate;
    }

    /**
     * Returns task description.
     *
     * @return task description
     **/
    public String taskDescription() {
        return taskDescription;
    }

    /**
     * Returns homework deadline.
     *
     * @return homework deadline
     **/
    public LocalDateTime deadline() {
        return deadline;
    }

    /**
     * Returns corresponding checker id.
     *
     * @return checker id as string
     **/
    public String getCheckerId() {
        return checkerId;
    }
}
