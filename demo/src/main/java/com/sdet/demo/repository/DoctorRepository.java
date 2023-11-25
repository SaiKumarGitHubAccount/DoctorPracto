package com.sdet.demo.repository;

import com.sdet.demo.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    Doctor save(Doctor doctor);

    List<Doctor> findByNameContainingIgnoreCase(String name);
//    List<Doctor> findById(long id);
    List<Doctor> findBySpecializationContainingIgnoreCase(String specialization);

    List<Doctor> findByNameContainingIgnoreCaseAndSpecializationContainingIgnoreCase(String name, String specialization);
    // Define custom queries or methods if needed
}
