package ru.java.hse.sd.controller;

/**
 * Stores information about homework solution.
 **/
public class Submission {
    private String homeworkId;

    public void setHomeworkId(String homeworkId) {
        this.homeworkId = homeworkId;
    }

    public void setSolutionUrl(String solutionUrl) {
        this.solutionUrl = solutionUrl;
    }

    private String solutionUrl;

    /**
     * Creates new instance of Submission object.
     * Initialises homeworkId and solutionUrl with the given values.
     *
     * @param homeworkId  homework id
     * @param solutionUrl homework solution url
     **/
    public Submission(String homeworkId, String solutionUrl) {
        this.homeworkId = homeworkId;
        this.solutionUrl = solutionUrl;
    }

    public Submission() {}

    /**
     * Returns homework id.
     *
     * @return homework id as string
     **/
    public String getHomeworkId() {
        return homeworkId;
    }

    /**
     * Returns homework solution url.
     *
     * @return url as string
     **/
    public String getSolutionUrl() {
        return solutionUrl;
    }
}
