package com.example.jobagapi.resource;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Size;
import java.time.LocalDate;

public class SaveInterviewResource {
    @DateTimeFormat
    private LocalDate date_Interview;

    @DateTimeFormat
    private LocalDate final_date_Interview;

    @Size(max = 30)
    private String link_Interview;

    public LocalDate getDate_Interview() {
        return date_Interview;
    }

    public SaveInterviewResource setDate_Interview(LocalDate date_Interview) {
        this.date_Interview = date_Interview;
        return this;
    }

    public LocalDate getFinal_date_Interview() {
        return final_date_Interview;
    }

    public SaveInterviewResource setFinal_date_Interview(LocalDate final_date_Interview) {
        this.final_date_Interview = final_date_Interview;
        return this;
    }

    public String getLink_Interview() {
        return link_Interview;
    }

    public SaveInterviewResource setLink_Interview(String link_Interview) {
        this.link_Interview = link_Interview;
        return this;
    }
}
