package ru.java.hse.sd.model.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Information about homework.
 **/
@Entity
@Table(name = "homework")
public class Homework {
    @Id
    private String id;

    @Column(name = "name", length = 250, nullable = false)
    private String name;

    @Column(name = "publication_date", nullable = false)
    private LocalDateTime publicationDate;

    @Column(name = "task_description", length = 1000, nullable = false)
    private String taskDescription;

    @Column(name = "deadline", nullable = false)
    private LocalDateTime deadline;

    @Column(name = "checker_id", length = 250, nullable = false)
    private String checkerId;

    /**
     * Creates new instance of Homework object.
     **/
    public Homework() {
    }

    /**
     * Creates new instance of Homework object.
     * Initialises name, publicationDate, taskDescription, deadline and checkerId with the given values.
     * Initialises id randomly.
     *
     * @param name            homework name
     * @param publicationDate homework publication date
     * @param taskDescription task description
     * @param deadline        homework deadline
     * @param checkerId       checker id
     **/
    public Homework(String name, LocalDateTime publicationDate, String taskDescription,
                    LocalDateTime deadline, String checkerId) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.publicationDate = publicationDate;
        this.taskDescription = taskDescription;
        this.deadline = deadline;
        this.checkerId = checkerId;
    }

    /**
     * Returns homework id.
     *
     * @return id as string
     **/
    public String getId() {
        return id;
    }

    /**
     * Sets homework id.
     *
     * @param id homework id
     **/
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Returns homework name.
     *
     * @return name as string
     **/
    public String getName() {
        return name;
    }

    /**
     * Sets homework name.
     *
     * @param name homework name
     **/
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns publication date.
     *
     * @return publication date
     **/
    public LocalDateTime getPublicationDate() {
        return publicationDate;
    }

    /**
     * Sets publication date.
     *
     * @param publicationDate publication date
     **/
    public void setPublicationDate(LocalDateTime publicationDate) {
        this.publicationDate = publicationDate;
    }

    /**
     * Returns task description.
     *
     * @return task description as string
     **/
    public String getTaskDescription() {
        return taskDescription;
    }

    /**
     * Sets task description.
     *
     * @param taskDescription task description
     **/
    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    /**
     * Returns homework deadline.
     *
     * @return deadline
     **/
    public LocalDateTime getDeadline() {
        return deadline;
    }

    /**
     * Sets homework deadline.
     *
     * @param deadline homework deadline
     **/
    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    /**
     * Returns checker id.
     *
     * @return checker id as string
     **/
    public String getCheckerId() {
        return checkerId;
    }

    /**
     * Sets checker id.
     *
     * @param checkerId checker id
     **/
    public void setCheckerId(String checkerId) {
        this.checkerId = checkerId;
    }
}

