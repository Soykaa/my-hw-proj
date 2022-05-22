package ru.java.hse.sd.model.view;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;

public class SubmissionView {
    @JsonFormat
    private final String homeworkId;
    @JsonFormat
    private final String solutionUrl;

    public SubmissionView(String homeworkId, String solutionUrl) {
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
