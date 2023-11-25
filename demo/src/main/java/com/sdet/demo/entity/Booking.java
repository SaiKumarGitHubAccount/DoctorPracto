package com.sdet.demo.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name = "bookings")
@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private long doctorId;
    private long patientId;
    private String bookingTime;

    public void setId(Long id) {
        this.id = id;
    }

    public void setDoctorId(long doctorId) {
        this.doctorId = doctorId;
    }

    public void setPatientId(long patientId) {
        this.patientId = patientId;
    }

    public void setBookingTime(String bookingTime) {
        this.bookingTime = bookingTime;
    }

    public Long getId() {
        return id;
    }

    public long getDoctorId() {
        return doctorId;
    }

    public long getPatientId() {
        return patientId;
    }

    public String getBookingTime() {
        return bookingTime;
    }

    //    @ManyToOne
//    @JoinColumn(name = "doctor_id", nullable = false)
//    private Doctor doctor;

}
