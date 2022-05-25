package ru.java.hse.sd.model.view;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

/**
 * Information about the attempt (for displaying).
 **/
public class AttemptView {
    @JsonFormat
    private final HomeworkView homework;
    @JsonFormat
    private final MarkView mark;
    @JsonFormat
    private final String comment;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss[.SSS]")
    private final LocalDateTime date;

    /**
     * Creates new instance of AttemptView object.
     * Initialises homework, mark and date with the given values.
     *
     * @param homework homework view
     * @param mark     mark view
     * @param comment  solution comment
     * @param date     date and time of the attempt
     **/
    public AttemptView(HomeworkView homework, MarkView mark, String comment,
                       LocalDateTime date) {
        this.homework = homework;
        this.mark = mark;
        this.comment = comment;
        this.date = date;
    }

    /**
     * Returns information about homework.
     *
     * @return homework info (view)
     **/
    public HomeworkView homework() {
        return homework;
    }

    /**
     * Returns information about checker mark.
     *
     * @return checker mark info (view)
     **/
    public MarkView mark() {
        return mark;
    }

    /**
     * Returns solution comment.
     *
     * @return comment as string
     **/
    public String comment() {
        return comment;
    }

    /**
     * Returns attempt date and time.
     *
     * @return date and time
     **/
    public LocalDateTime date() {
        return date;
    }
}
