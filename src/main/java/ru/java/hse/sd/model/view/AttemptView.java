package ru.java.hse.sd.model.view;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;

public class AttemptView {
    @JsonFormat
    private final HomeworkView homework;
    @JsonFormat
    private final MarkView mark;
    @JsonFormat
    private final String comment;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss[.SSS]")
    private final LocalDateTime date;

    public AttemptView(HomeworkView homework, MarkView mark, String comment,
        LocalDateTime date) {
        this.homework = homework;
        this.mark = mark;
        this.comment = comment;
        this.date = date;
    }

    public HomeworkView homework() {
        return homework;
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
