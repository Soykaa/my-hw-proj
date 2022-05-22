package ru.java.hse.sd.model.hibernate;

import java.time.LocalDateTime;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import ru.java.hse.sd.model.Mark;

@Entity
@Table(name="attempt")
public class Attempt {
    @Id
    private String id;

    @Column(name="homework_id", length=250, nullable=false)
    private String homeworkId;

    @Column(name="date_time", nullable=false)
    private java.time.LocalDateTime dateTime;

    @Enumerated(EnumType.STRING)
    @Column(name="mark")
    private Mark mark;

    @Column(name="comment", length=600)
    private String comment;

    public Attempt() {
    }

    public Attempt(String homeworkId, LocalDateTime dateTime) {
        this.id = UUID.randomUUID().toString();
        this.homeworkId = homeworkId;
        this.dateTime = dateTime;
        this.mark = null;
        this.comment = null;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHomeworkId() {
        return homeworkId;
    }

    public void setHomeworkId(String homeworkId) {
        this.homeworkId = homeworkId;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime localDateTime) {
        this.dateTime = localDateTime;
    }

    public Mark getMark() {
        return mark;
    }

    public void setMark(Mark mark) {
        this.mark = mark;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
