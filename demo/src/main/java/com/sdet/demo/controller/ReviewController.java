package com.sdet.demo.controller;

import com.sdet.demo.entity.Doctor;
import com.sdet.demo.entity.Review;
import com.sdet.demo.payload.DoctorDto;
import com.sdet.demo.repository.DoctorRepository;
import com.sdet.demo.service.PatientService;
import com.sdet.demo.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;
    @Autowired
    private DoctorRepository doctorRepository;

    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody Review review) {
        Review savereview = reviewService.createReview(review);
        return new ResponseEntity<>(savereview, HttpStatus.CREATED);
    }

    @GetMapping("/{doctorId}")
    public ResponseEntity<DoctorDto> getReviewsByDoctorId(@PathVariable long doctorId) {
        Doctor doctor = doctorRepository.findById(doctorId).get();
        List<Review> reviews = reviewService.getReviewByDoctorId(doctorId);

        double sumOfRatings = 0;
        for (Review review : reviews) {
            sumOfRatings += review.getRating();
        }


        double overallRatingPercentage = sumOfRatings / reviews.size();
        double RatingPercentage = (overallRatingPercentage / 5.0) * 100.0;


        DoctorDto dto = new DoctorDto();
        dto.setDoctor(doctor);
        dto.setReviews(reviews);
        dto.setRatingPercentage(RatingPercentage);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
