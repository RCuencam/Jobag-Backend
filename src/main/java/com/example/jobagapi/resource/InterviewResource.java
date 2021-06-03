package com.example.jobagapi.resource;

import java.time.LocalDate;

public class InterviewResource {
    private Long id;
    private LocalDate date_Interview;
    private LocalDate final_date_Interview;
    private String link_Interview;

    public Long getId() {
        return id;
    }

    public InterviewResource setId(Long id) {
        this.id = id;
        return this;
    }

    public LocalDate getDate_Interview() {
        return date_Interview;
    }

    public InterviewResource setDate_Interview(LocalDate date_Interview) {
        this.date_Interview = date_Interview;
        return this;
    }

    public LocalDate getFinal_date_Interview() {
        return final_date_Interview;
    }

    public InterviewResource setFinal_date_Interview(LocalDate final_date_Interview) {
        this.final_date_Interview = final_date_Interview;
        return this;
    }

    public String getLink_Interview() {
        return link_Interview;
    }

    public InterviewResource setLink_Interview(String link_Interview) {
        this.link_Interview = link_Interview;
        return this;
    }
}
