package com.sdet.demo.payload;



public class BookingDto {
    private  long doctorId;
    private  long patientId;
    private  String bookingTime;

    public void setDoctorId(long doctorId) {
        this.doctorId = doctorId;
    }

    public void setPatientId(long patientId) {
        this.patientId = patientId;
    }

    public void setBookingTime(String bookingTime) {
        this.bookingTime = bookingTime;
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
}
