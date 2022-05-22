package ru.java.hse.sd.model;

import java.io.Serializable;

/**
 * Attempt at homework.
 **/
public class Submission implements Serializable {
    private final String attemptId;
    private final String homeworkId;
    private final String solutionUrl;

    /**
     * Creates new instance of Submission object.
     * Initialises attemptId, homeworkId and solutionUrl with the given values.
     *
     * @param homeworkId  homework id
     * @param solutionUrl homework solution url
     * @param attemptId   attempt id
     **/
    public Submission(String attemptId, String homeworkId, String solutionUrl) {
        this.homeworkId = homeworkId;
        this.solutionUrl = solutionUrl;
        this.attemptId = attemptId;
    }

    /**
     * Returns homework id.
     *
     * @return homework id as string
     **/
    public String getHomeworkId() {
        return homeworkId;
    }

    /**
     * Returns solution url.
     *
     * @return solution url as string
     **/
    public String getSolutionUrl() {
        return solutionUrl;
    }

    /**
     * Returns attempt id.
     *
     * @return attempt id as string
     **/
    public String getAttemptId() {
        return attemptId;
    }
}
