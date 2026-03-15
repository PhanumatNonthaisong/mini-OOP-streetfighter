package com.fightbooking.model;

public class Zone {

    private String zoneName;
    private int capacity;
    private int availableSeats;
    private double studentPrice;
    private double normalPrice;

    public Zone(String zoneName, int capacity, int availableSeats,
                double studentPrice, double normalPrice) {

        this.zoneName = zoneName;
        this.capacity = capacity;
        this.availableSeats = availableSeats;
        this.studentPrice = studentPrice;
        this.normalPrice = normalPrice;
    }

    public String getZoneName() {
        return zoneName;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public double getStudentPrice() {
        return studentPrice;
    }

    public double getNormalPrice() {
        return normalPrice;
    }

    public boolean reserveSeats(int amount) {

        if (availableSeats >= amount) {
            availableSeats -= amount;
            return true;
        }

        return false;
    }
}