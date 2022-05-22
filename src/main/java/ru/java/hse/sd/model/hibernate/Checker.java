package ru.java.hse.sd.model.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Information about checker.
 **/
@Entity
@Table(name = "checker")
public class Checker {
    @Id
    private String id;

    @Column(name = "code", nullable = false)
    private String code;

    /**
     * Creates new instance of Checker object.
     **/
    public Checker() {
    }

    /**
     * Creates new instance of Checker object.
     * Initialises id and code with the given values.
     *
     * @param id   checker id
     * @param code checker code
     **/
    public Checker(String id, String code) {
        this.id = id;
        this.code = code;
    }
}
