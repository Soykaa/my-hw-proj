package ru.java.hse.sd.model.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="checker")
public class Checker {
    @Id
    private String id;

    @Column(name="code", nullable=false)
    private String code;

    public Checker() {
    }

    public Checker(String id, String code) {
        this.id = id;
        this.code = code;
    }
}
