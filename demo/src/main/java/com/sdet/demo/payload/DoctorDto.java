package com.sdet.demo.payload;

import com.sdet.demo.entity.Doctor;
import com.sdet.demo.entity.Review;

import java.util.List;


public class DoctorDto {
    private Doctor doctor;
    private List<Review> reviews;
    private double RatingPercentage;

    public void setRatingPercentage(double ratingPercentage) {
        RatingPercentage = ratingPercentage;
    }

    public double getRatingPercentage() {
        return RatingPercentage;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}
