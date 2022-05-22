package ru.java.hse.sd.model.view;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;

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

    public HomeworkView(String id, String name, LocalDateTime publicationDate,
        String taskDescription, LocalDateTime deadline, String checkerId) {
        this.id = id;
        this.name = name;
        this.publicationDate = publicationDate;
        this.taskDescription = taskDescription;
        this.deadline = deadline;
        this.checkerId = checkerId;
    }

    public HomeworkView(String name, LocalDateTime publicationDate,
        String taskDescription, LocalDateTime deadline, String checkerId) {
        this(null, name, publicationDate, taskDescription, deadline, checkerId);
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

    public String checkerId() {
        return checkerId;
    }
}
