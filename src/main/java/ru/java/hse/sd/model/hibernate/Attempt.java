package ru.java.hse.sd.model.hibernate;

import ru.java.hse.sd.model.Mark;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Information about homework submission attempt.
 **/
@Entity
@Table(name = "attempt")
public class Attempt {
    @Id
    private String id;

    @Column(name = "homework_id", length = 250, nullable = false)
    private String homeworkId;

    @Column(name = "date_time", nullable = false)
    private LocalDateTime dateTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "mark")
    private Mark mark;

    @Column(name = "comment", length = 600)
    private String comment;

    /**
     * Creates new instance of Attempt object.
     **/
    public Attempt() {
    }

    /**
     * Creates new instance of Attempt object.
     * Initialises homeworkId and dateTime with the given values.
     * Initialises mark and comment with null.
     *
     * @param homeworkId homework id
     * @param dateTime   submission date and time
     **/
    public Attempt(String homeworkId, LocalDateTime dateTime) {
        this.id = UUID.randomUUID().toString();
        this.homeworkId = homeworkId;
        this.dateTime = dateTime;
        this.mark = null;
        this.comment = null;
    }

    /**
     * Returns attempt id as string.
     *
     * @return attempt id as string
     **/
    public String getId() {
        return id;
    }

    /**
     * Sets attempt id.
     *
     * @param id attempt id
     **/
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Returns homework id as string.
     *
     * @return homework id as string
     **/
    public String getHomeworkId() {
        return homeworkId;
    }

    /**
     * Sets homework id.
     *
     * @param homeworkId homework id
     **/
    public void setHomeworkId(String homeworkId) {
        this.homeworkId = homeworkId;
    }

    /**
     * Returns submission date and time.
     *
     * @return date and time
     **/
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    /**
     * Sets submission date and time.
     *
     * @param localDateTime date and time
     **/
    public void setDateTime(LocalDateTime localDateTime) {
        this.dateTime = localDateTime;
    }

    /**
     * Returns checker mark.
     *
     * @return checker mark
     **/
    public Mark getMark() {
        return mark;
    }

    /**
     * Sets checker mark.
     *
     * @param mark checker mark
     **/
    public void setMark(Mark mark) {
        this.mark = mark;
    }

    /**
     * Returns solution comment.
     *
     * @return comment as string
     **/
    public String getComment() {
        return comment;
    }

    /**
     * Sets solution comment.
     *
     * @param comment solution comment
     **/
    public void setComment(String comment) {
        this.comment = comment;
    }
}
