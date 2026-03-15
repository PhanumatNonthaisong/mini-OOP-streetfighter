package com.fightbooking.service;

import com.fightbooking.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BookingService {

    private List<Booking> bookings = new ArrayList<>();

    public Booking createBooking(User user, Zone zone, int amount){

        if(zone.getAvailableSeats() < amount){
            return null;
        }

        zone.reserveSeats(amount);

        double price;

        if(user.getUserType().equals("STUDENT")){
            price = zone.getStudentPrice() * amount;
        }else{
            price = zone.getNormalPrice() * amount;
        }

        Booking booking = new Booking(
                UUID.randomUUID().toString(),
                user,
                zone,
                amount,
                price,
                "PENDING"
        );

        bookings.add(booking);

        return booking;
    }

    public List<Booking> getBookings(){
        return bookings;
    }

    public void approveBooking(String bookingId){

        for(Booking b : bookings){

            if(b.getBookingId().equals(bookingId)){
                b.setStatus("APPROVED");
            }

        }

    }
}