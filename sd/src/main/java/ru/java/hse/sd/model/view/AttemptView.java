package ru.java.hse.sd.model.view;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;

public class AttemptView {
    private final HomeworkView homework;
    private final StudentView student;
    private final MarkView mark;
    private final String comment;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss[.SSS]")
    private final LocalDateTime date;

    public AttemptView(HomeworkView homework, StudentView student, MarkView mark, String comment,
        LocalDateTime date) {
        this.homework = homework;
        this.student = student;
        this.mark = mark;
        this.comment = comment;
        this.date = date;
    }

    public HomeworkView homework() {
        return homework;
    }

    public StudentView student() {
        return student;
    }

    public MarkView mark() {
        return mark;
    }

    public String comment() {
        return comment;
    }

    public LocalDateTime date() {
        return date;
    }
}
