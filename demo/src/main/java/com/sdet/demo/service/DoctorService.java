package com.sdet.demo.service;

//DoctorService.java

import com.sdet.demo.entity.Doctor;
import com.sdet.demo.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public Doctor addDoctor(Doctor doctor) {
        // You can add any business logic/validation here before saving to the database
        return doctorRepository.save(doctor);
    }

    public Optional<Doctor> getDoctorById(Long doctorId) {
        Optional<Doctor> byId = doctorRepository.findById(doctorId);
        return byId;
    }
}