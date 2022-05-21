package ru.java.hse.sd.model.view;

import com.fasterxml.jackson.annotation.JsonFormat;

public class MarkView {
    @JsonFormat
    private final String mark;

    public MarkView(String mark) {
        this.mark = mark;
    }

    public String getMark() {
        return mark;
    }
}
