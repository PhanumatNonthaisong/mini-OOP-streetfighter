package com.fightbooking.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.Alert;

public class SeatController {

    @FXML
    private Label zoneLabel;

    @FXML
    private Spinner<Integer> seatSpinner;

    private int availableSeats = 10;

    public void setZone(String zone){

        zoneLabel.setText("Zone : " + zone);

        if(zone.startsWith("A")) availableSeats = 50;
        if(zone.startsWith("B")) availableSeats = 80;
        if(zone.startsWith("C")) availableSeats = 120;

        seatSpinner.setValueFactory(
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1,availableSeats,1)
        );

    }

    @FXML
    private void confirmBooking(){

        int amount = seatSpinner.getValue();

        if(amount > availableSeats){

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Not enough seats");
            alert.show();

            return;
        }

        System.out.println("Seat selected : " + amount);

    }

}