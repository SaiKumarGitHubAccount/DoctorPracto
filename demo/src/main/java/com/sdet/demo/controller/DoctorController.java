package com.sdet.demo.controller;
//DoctorController.java
import com.sdet.demo.entity.Doctor;
import com.sdet.demo.repository.DoctorRepository;
import com.sdet.demo.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private DoctorRepository doctorRepository;
    @PostMapping
    public ResponseEntity<Doctor> addDoctor(@RequestBody Doctor doctor) {
        Doctor addedDoctor = doctorService.addDoctor(doctor);
        return ResponseEntity.ok(addedDoctor);
    }
    // Endpoint to search doctors by name
    //GET http://localhost:7000/api/doctors/searchByName?name=Dr. Mitchell
    @GetMapping("/searchByName")
    public List<Doctor> searchByName(@RequestParam String name) {
        return doctorRepository.findByNameContainingIgnoreCase(name);
    }

    // Endpoint to search doctors by specialization
    //GET http://localhost:7000/api/doctors/searchBySpecialization?specialization=Cardiology
    @GetMapping("/searchBySpecialization")
    public List<Doctor> searchBySpecialization(@RequestParam String specialization) {
        return doctorRepository.findBySpecializationContainingIgnoreCase(specialization);
    }
    //GET http://localhost:7000/api/doctors/search?name=Dr.&specialization=Cardiology
    //GET http://localhost:8080/api/doctors/search?name=Dr. Smith
    //GET http://localhost:8080/api/doctors/search?specialization=Cardiology
    //GET http://localhost:8080/api/doctors/search
    @GetMapping("/search")
    public List<Doctor> searchDoctors(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String specialization) {
        if (name != null && specialization != null) {
            // Search by both name and specialization
            return doctorRepository.findByNameContainingIgnoreCaseAndSpecializationContainingIgnoreCase(name, specialization);
        } else if (name != null) {
            // Search by name only
            return doctorRepository.findByNameContainingIgnoreCase(name);
        } else if (specialization != null) {
            // Search by specialization only
            return doctorRepository.findBySpecializationContainingIgnoreCase(specialization);
        } else {
            // Return all doctors if no parameters are provided
            return doctorRepository.findAll();
        }
    }
}
