package ru.java.hse.sd.controller;

public class Submission {
    private final String homeworkId;
    private final String solutionUrl;

    public Submission(String homeworkId, String solutionUrl) {
        this.homeworkId = homeworkId;
        this.solutionUrl = solutionUrl;
    }

    public String getHomeworkId() {
        return homeworkId;
    }

    public String getSolutionUrl() {
        return solutionUrl;
    }
}
