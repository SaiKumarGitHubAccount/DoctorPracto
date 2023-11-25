package com.sdet.demo.config;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class TimeSlotManager {

    private List<String> availableTimeSlots;

    public void setAvailableTimeSlots(List<String> availableTimeSlots) {
        this.availableTimeSlots = availableTimeSlots;
    }

    public TimeSlotManager() {
        this.availableTimeSlots = new ArrayList<>();
        initializeTimeSlots();
    }

    private void initializeTimeSlots() {
        availableTimeSlots.add("10:15AM");
        availableTimeSlots.add("11:15AM");
        availableTimeSlots.add("12:15PM");
        // Add more initial time slots as needed
    }

    public List<String> getAvailableTimeSlots() {
        return new ArrayList<>(availableTimeSlots);
    }

    public boolean bookTimeSlot(String timeSlot) {
        if (availableTimeSlots.contains(timeSlot)) {
            availableTimeSlots.remove(timeSlot);
            return true; // Booking successful
        } else {
            return false; // Time slot not available
        }
    }

    public void releaseTimeSlot(String timeSlot) {
        availableTimeSlots.add(timeSlot);
    }

    // Add more methods as needed

    public static void main(String[] args) {
        TimeSlotManager timeSlotManager = new TimeSlotManager();

        // Example: Book a time slot
        String timeSlotToBook = "11:15AM";
        if (timeSlotManager.bookTimeSlot(timeSlotToBook)) {
            System.out.println("Booking successful for " + timeSlotToBook);
        } else {
            System.out.println("Time slot not available: " + timeSlotToBook);
        }

        // Example: Get available time slots
        List<String> availableSlots = timeSlotManager.getAvailableTimeSlots();
        System.out.println("Available Time Slots: " + availableSlots);
    }
}
