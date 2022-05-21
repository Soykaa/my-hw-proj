package ru.java.hse.sd.model.hibernate;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="homework")
public class Homework {
    @Id
    private String id;

    @Column(name="name", length=250, nullable=false)
    private String name;

    @Column(name="publication_date", nullable=false)
    private java.time.LocalDateTime publicationDate;

    @Column(name="task_description", length=1000, nullable=false)
    private String taskDescription;

    @Column(name="deadline", nullable=false)
    private java.time.LocalDateTime deadline;

    @Column(name="checker_id", length=250, nullable = false)
    private String checkerId;

    public Homework() {
    }

    public Homework(String id, String name, LocalDateTime publicationDate,
        String taskDescription, LocalDateTime deadline, String checkerId) {
        this.id = id;
        this.name = name;
        this.publicationDate = publicationDate;
        this.taskDescription = taskDescription;
        this.deadline = deadline;
        this.checkerId = checkerId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDateTime publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    public String getCheckerId() {
        return checkerId;
    }

    public void setCheckerId(String checkerId) {
        this.checkerId = checkerId;
    }
}

