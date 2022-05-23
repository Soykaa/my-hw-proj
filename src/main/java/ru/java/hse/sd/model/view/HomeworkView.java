package ru.java.hse.sd.model.view;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

/**
 * Information about homework (for displaying).
 **/
public class HomeworkView {
    @JsonFormat
    private final String id;
    @JsonFormat
    private final String name;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss[.SSS]")
    private final LocalDateTime publicationDate;
    @JsonFormat
    private final String taskDescription;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss[.SSS]")
    private final LocalDateTime deadline;
    @JsonFormat
    private final String checkerId;

    /**
     * Creates new instance of HomeworkView object.
     * Initialises id, name, publicationDate, taskDescription, deadline and checkerId with the given values.
     *
     * @param id              homework id
     * @param name            homework name
     * @param publicationDate publication date
     * @param taskDescription task description
     * @param deadline        homework deadline
     * @param checkerId       checker id
     **/
    public HomeworkView(String id, String name, LocalDateTime publicationDate,
                        String taskDescription, LocalDateTime deadline, String checkerId) {
        this.id = id;
        this.name = name;
        this.publicationDate = publicationDate;
        this.taskDescription = taskDescription;
        this.deadline = deadline;
        this.checkerId = checkerId;
    }

    /**
     * Creates new instance of HomeworkView object.
     * Initialises name, publicationDate, taskDescription, deadline and checkerId with the given values.
     * Initialises id with null.
     *
     * @param name            homework name
     * @param publicationDate publication date
     * @param taskDescription task description
     * @param deadline        homework deadline
     * @param checkerId       checker id
     **/
    public HomeworkView(String name, LocalDateTime publicationDate,
                        String taskDescription, LocalDateTime deadline, String checkerId) {
        this(null, name, publicationDate, taskDescription, deadline, checkerId);
    }

    /**
     * Returns homework id.
     *
     * @return homework id
     **/
    public String id() {
        return id;
    }

    /**
     * Returns homework name.
     *
     * @return homework name
     **/
    public String name() {
        return name;
    }

    /**
     * Returns homework publication date.
     *
     * @return publication date
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
     * @return checker id
     **/
    public String checkerId() {
        return checkerId;
    }
}
