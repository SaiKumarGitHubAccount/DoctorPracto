package com.sdet.demo.entity;


import javax.persistence.*;

@Entity
public class Doctor {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String qualification;
    private String specialization;
    private int experience;
    private double ratings;
    private String description;

    // Constructors, getters, and setters

    public Doctor() {
    }

    public Doctor(String name, String qualification, String specialization, int experience, double ratings, String description) {
        this.name = name;
        this.qualification = qualification;
        this.specialization = specialization;
        this.experience = experience;
        this.ratings = ratings;
        this.description = description;
    }

    // Getters and setters for other fields

    // Don't forget to generate getters and setters for all fields using your IDE or manually.

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public double getRatings() {
        return ratings;
    }

    public void setRatings(double ratings) {
        this.ratings = ratings;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
