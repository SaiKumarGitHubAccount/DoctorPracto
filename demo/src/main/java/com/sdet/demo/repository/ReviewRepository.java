package com.sdet.demo.repository;

import com.sdet.demo.entity.Doctor;
import com.sdet.demo.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review,Long> {
    List<Review> findByDoctorId(long Id);
}
