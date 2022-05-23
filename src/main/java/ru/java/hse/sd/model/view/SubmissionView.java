package ru.java.hse.sd.model.view;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Information about submission (for displaying).
 **/
public class SubmissionView {
    @JsonFormat
    private final String homeworkId;
    @JsonFormat
    private final String solutionUrl;

    /**
     * Creates new instance of SubmissionView object.
     * Initialises homeworkId and solutionUrl with the given values.
     *
     * @param homeworkId  homework id
     * @param solutionUrl solution url
     **/
    public SubmissionView(String homeworkId, String solutionUrl) {
        this.homeworkId = homeworkId;
        this.solutionUrl = solutionUrl;
    }

    /**
     * Returns homework id.
     *
     * @return homework id
     **/
    public String getHomeworkId() {
        return homeworkId;
    }

    /**
     * Returns solution url.
     *
     * @return solution url
     **/
    public String getSolutionUrl() {
        return solutionUrl;
    }
}
