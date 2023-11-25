package com.sdet.demo.entity;

import javax.persistence.*;


@Entity
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long doctorId;
    private long patientId;
    private long rating;

    public void setRating(long rating) {
        this.rating = rating;
    }

    public long getRating() {
        return rating;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setDoctorId(long doctorId) {
        this.doctorId = doctorId;
    }

    public void setPatientId(long patientId) {
        this.patientId = patientId;
    }

    public long getId() {
        return id;
    }

    public long getDoctorId() {
        return doctorId;
    }

    public long getPatientId() {
        return patientId;
    }
}
