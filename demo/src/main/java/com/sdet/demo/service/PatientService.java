package com.sdet.demo.service;

import com.sdet.demo.entity.Patient;
import com.sdet.demo.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    public Patient createPatient(Patient patient) {
        Patient savepatient = patientRepository.save(patient);
        return savepatient;
    }
}
