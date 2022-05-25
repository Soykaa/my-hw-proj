package ru.java.hse.sd.controller;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

/**
 * Stores information about home task.
 **/
public class Task {
    private String name;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss[.SSS]")
    private LocalDateTime publicationDate;
    private String taskDescription;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss[.SSS]")
    private LocalDateTime deadline;

    private String checkerId;

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
     * Creates new instance of Task object.
     **/
    public Task() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPublicationDate(LocalDateTime publicationDate) {
        this.publicationDate = publicationDate;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    public void setCheckerId(String checkerId) {
        this.checkerId = checkerId;
    }

    /**
     * Returns homework name.
     *
     * @return homework name as string
     **/
    public String getName() {
        return name;
    }

    /**
     * Returns homework publication date.
     *
     * @return homework publication date
     **/
    public LocalDateTime getPublicationDate() {
        return publicationDate;
    }

    /**
     * Returns task description.
     *
     * @return task description
     **/
    public String getTaskDescription() {
        return taskDescription;
    }

    /**
     * Returns homework deadline.
     *
     * @return homework deadline
     **/
    public LocalDateTime getDeadline() {
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
