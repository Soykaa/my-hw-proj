package ru.java.hse.sd.model;

import java.io.Serializable;

public class Submission implements Serializable {
    private final String attemptId;
    private final String homeworkId;
    private final String solutionUrl;

    public Submission(String attemptId, String homeworkId, String solutionUrl) {
        this.homeworkId = homeworkId;
        this.solutionUrl = solutionUrl;
        this.attemptId = attemptId;
    }

    public String getHomeworkId() {
        return homeworkId;
    }

    public String getSolutionUrl() {
        return solutionUrl;
    }

    public String getAttemptId() {
        return attemptId;
    }
}
