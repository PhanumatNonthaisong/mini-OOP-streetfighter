package com.fightbooking.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class EventDetailController {
	@FXML
	private Button bookButton;

	@FXML
	private void goBooking(javafx.event.ActionEvent event){

	    try{

	        FXMLLoader loader = new FXMLLoader(
	                getClass().getResource("/fxml/booking.fxml")
	        );

	        Scene scene = new Scene(loader.load(),1000,600);

	        Stage stage = (Stage) ((Button)event.getSource()).getScene().getWindow();

	        stage.setScene(scene);

	    }catch(Exception e){
	        e.printStackTrace();
	    }

	}
}