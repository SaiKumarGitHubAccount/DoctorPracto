package com.sdet.demo.service;

import com.sdet.demo.entity.Doctor;
import com.sdet.demo.entity.Patient;
import com.sdet.demo.entity.Review;
import com.sdet.demo.repository.DoctorRepository;
import com.sdet.demo.repository.PatientRepository;
import com.sdet.demo.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    public Review createReview(Review review) {
        Doctor doctor = doctorRepository.findById(review.getDoctorId()).get();
        Patient patient = patientRepository.findById(review.getPatientId()).get();
        Review saveReview = null;
        if (doctor != null || patient != null) {
            saveReview = reviewRepository.save(review);
        }
        return saveReview;
    }

    public List<Review> getReviewByDoctorId(long doctorId) {
        List<Review> reviews = reviewRepository.findByDoctorId(doctorId);
        return reviews;
    }
}
