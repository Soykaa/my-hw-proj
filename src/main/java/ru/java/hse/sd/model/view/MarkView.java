package ru.java.hse.sd.model.view;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Information about mark (for displaying).
 **/
public class MarkView {
    @JsonFormat
    private final String mark;

    /**
     * Creates new instance of MarkView object.
     * Initialises mark with the given value.
     *
     * @param mark mark
     **/
    public MarkView(String mark) {
        this.mark = mark;
    }

    /**
     * Returns mark.
     *
     * @return mark as string
     **/
    public String getMark() {
        return mark;
    }
}
