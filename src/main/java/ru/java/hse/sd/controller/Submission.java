package ru.java.hse.sd.controller;

/**
 * Stores information about homework solution.
 **/
public class Submission {
    private final String homeworkId;
    private final String solutionUrl;

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
