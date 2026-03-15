package com.fightbooking.model;

public class Booking {

    private String bookingId;
    private User user;
    private Zone zone;
    private int ticketAmount;
    private double totalPrice;
    private String status;

    public Booking(String bookingId, User user, Zone zone,
                   int ticketAmount, double totalPrice, String status) {

        this.bookingId = bookingId;
        this.user = user;
        this.zone = zone;
        this.ticketAmount = ticketAmount;
        this.totalPrice = totalPrice;
        this.status = status;
    }

    public String getBookingId() {
        return bookingId;
    }

    public User getUser() {
        return user;
    }

    public Zone getZone() {
        return zone;
    }

    public int getTicketAmount() {
        return ticketAmount;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}