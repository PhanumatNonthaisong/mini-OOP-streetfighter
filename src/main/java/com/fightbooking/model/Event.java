package com.fightbooking.model;

public class Event {

	private String name;
    private String date;
    private String venue;
    private double price;


    public Event(String name, String date, String venue, double price) {
        this.name = name;
        this.date = date;
        this.venue = venue;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getVenue() {
        return venue;
    }

    public double getPrice() {
        return price;
    }
}