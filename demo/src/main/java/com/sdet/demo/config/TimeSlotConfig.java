package com.sdet.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class TimeSlotConfig {

    @Bean
    public List<String> availableTimeSlot() {
        List<String> availableTimeSlot = new ArrayList<>();
        availableTimeSlot.add("10:15AM");
        availableTimeSlot.add("11:15AM");
        availableTimeSlot.add("12:15PM");
        return availableTimeSlot;
    }
}
