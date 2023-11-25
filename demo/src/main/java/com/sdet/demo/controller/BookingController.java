package com.sdet.demo.controller;


import com.sdet.demo.entity.Booking;
import com.sdet.demo.entity.Doctor;
//import com.sdet.demo.service.BookingService;
import com.sdet.demo.payload.BookingDto;
import com.sdet.demo.service.BookingService;
import com.sdet.demo.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @PostMapping
    public ResponseEntity<String> bookAnAppointment(@RequestBody BookingDto bookingDto) {
        bookingService.bookAppointment(bookingDto);
        return new ResponseEntity<>("Booking is Confirmed!", HttpStatus.CREATED);
    }


//    @Autowired
//    private BookingService bookingService;
//
//    @Autowired
//    private DoctorService doctorService;
//
//    // Endpoint to create a booking
//    @PostMapping("/create")
//    public ResponseEntity<Booking> createBooking(
//            @RequestParam Long doctorId,
//            @RequestParam LocalDateTime slot1,
//            @RequestParam LocalDateTime slot2,
//            @RequestParam LocalDateTime slot3) {
//
//        Optional<Doctor> optionalDoctor = doctorService.getDoctorById(doctorId);
//        if (optionalDoctor.isPresent()) {
//            Doctor doctor = optionalDoctor.get();
//            Booking booking = bookingService.saveBooking(doctor, slot1, slot2, slot3);
//            return new ResponseEntity<>(booking, HttpStatus.CREATED);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//    // Endpoint to get all bookings
//    @GetMapping("/all")
//    public List<Booking> getAllBookings() {
//        return bookingService.getAllBookings();
//    }
//
//    // Endpoint to get a booking by ID
//    @GetMapping("/{id}")
//    public ResponseEntity<Booking> getBookingById(@PathVariable Long id) {
//        Optional<Booking> optionalBooking = bookingService.getBookingById(id);
//        return optionalBooking.map(booking -> new ResponseEntity<>(booking, HttpStatus.OK))
//                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
//    }
//
//    // Endpoint to get bookings for a specific doctor
//    @GetMapping("/doctor/{doctorId}")
//    public ResponseEntity<List<Booking>> getBookingsByDoctor(@PathVariable Long doctorId) {
//        Optional<Doctor> optionalDoctor = doctorService.getDoctorById(doctorId);
//        if (optionalDoctor.isPresent()) {
//            Doctor doctor = optionalDoctor.get();
//            List<Booking> bookings = bookingService.getBookingsByDoctor(doctor);
//            return new ResponseEntity<>(bookings, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//    // Add more endpoints as needed
//
//    // Endpoint to delete a booking by ID
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<Void> deleteBooking(@PathVariable Long id) {
//        Optional<Booking> optionalBooking = bookingService.getBookingById(id);
//        if (optionalBooking.isPresent()) {
//            bookingService.deleteBooking(id);
//            return new ResponseEntity<>(HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
}
