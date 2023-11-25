package com.sdet.demo.service;
//import com.sdet.demo.entity.Booking;
//import com.sdet.demo.entity.Doctor;

import com.sdet.demo.config.TimeSlotManager;
import com.sdet.demo.entity.Booking;
import com.sdet.demo.payload.BookingDto;
import com.sdet.demo.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

//
//import java.time.LocalDateTime;
//import java.util.List;
//import java.util.Optional;
//
@Service
public class BookingService {


//    @Autowired
//    private List<String> availableTimeSlot;

    // Your existing methods...

    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private TimeSlotManager timeSlotManager;
    public void bookAppointment(BookingDto bookingDto) {
        List<String> availableTimeSlot=timeSlotManager.getAvailableTimeSlots();
        Booking booking = new Booking();

        for (String slots : availableTimeSlot) {
            if (slots.equals(bookingDto.getBookingTime())) {
                booking.setBookingTime(bookingDto.getBookingTime());
                availableTimeSlot.remove(slots);
                timeSlotManager.setAvailableTimeSlots(availableTimeSlot);
            }
        }

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        // Schedule the task to run every 24 hours
        scheduler.scheduleAtFixedRate(() -> {
            System.out.println("Executing task at 24 Hours.....");
            availableTimeSlot.add("10:15AM");
            availableTimeSlot.add("11:15AM");
            availableTimeSlot.add("12:15PM");
        }, 0, 24 * 60, TimeUnit.HOURS);


        booking.setDoctorId(bookingDto.getDoctorId());
        booking.setPatientId(bookingDto.getPatientId());
        if (booking.getBookingTime() != null) {
            bookingRepository.save(booking);
        } else {
            System.out.println("Time Slot Not Available!");
        }

    }

//
//    // Method to save a booking
//    public Booking saveBooking(Doctor doctor, LocalDateTime slot1, LocalDateTime slot2, LocalDateTime slot3) {
//        Booking booking = new Booking(doctor, slot1, slot2, slot3);
//        return bookingRepository.save(booking);
//    }
//
//    // Method to find all bookings
//    public List<Booking> getAllBookings() {
//        return bookingRepository.findAll();
//    }
//
//    // Method to find a booking by ID
//    public Optional<Booking> getBookingById(Long id) {
//        return bookingRepository.findById(id);
//    }
//
//    // Method to find bookings for a specific doctor
//    public List<Booking> getBookingsByDoctor(Doctor doctor) {
//        return bookingRepository.findByDoctor(doctor);
//    }
//
//    // Add more methods as needed for your use case
//
//    // Method to delete a booking by ID
//    public void deleteBooking(Long id) {
//        bookingRepository.deleteById(id);
//    }
}
