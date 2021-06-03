package com.example.jobagapi.domain.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.print.attribute.standard.MediaSize;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Time;
import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

@Entity
@Table(name = "interviews")
public class Interview extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @DateTimeFormat
    private LocalDate date_Interview;

    @DateTimeFormat
    private LocalDate final_date_Interview;

    @NotNull
    @Size(max = 30)
    private String link_Interview;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "postulant_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Postulant postulant;


    public Long getId() {
        return id;
    }

    public Interview setId(Long id) {
        this.id = id;
        return this;
    }

    public LocalDate getDate_Interview() {
        return date_Interview;
    }

    public Interview setDate_Interview(LocalDate date_Interview) {
        this.date_Interview = date_Interview;
        return this;
    }

    public LocalDate getFinal_date_Interview() {
        return final_date_Interview;
    }

    public Interview setFinal_date_Interview(LocalDate final_date_Interview) {
        this.final_date_Interview = final_date_Interview;
        return this;
    }

    public String getLink_Interview() {
        return link_Interview;
    }

    public Interview setLink_Interview(String link_Interview) {
        this.link_Interview = link_Interview;
        return this;
    }

    public Postulant getPostulant() {
        return postulant;
    }

    public Interview setPostulant(Postulant postulant) {
        this.postulant = postulant;
        return this;
    }
}
