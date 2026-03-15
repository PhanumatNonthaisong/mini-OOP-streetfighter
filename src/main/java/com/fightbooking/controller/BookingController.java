package com.fightbooking.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;

public class BookingController {

    @FXML
    private void selectZone(javafx.event.ActionEvent event){

        try{

            Button btn = (Button) event.getSource();
            String zone = btn.getText();

            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/fxml/seat.fxml")
            );

            Scene scene = new Scene(loader.load(),600,400);

            SeatController controller = loader.getController();
            controller.setZone(zone);

            Stage stage = (Stage) btn.getScene().getWindow();
            stage.setScene(scene);

        }catch(Exception e){
            e.printStackTrace();
        }

    }

    @FXML
    private void goBack(){

        try{

            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/fxml/event.fxml")
            );

            Scene scene = new Scene(loader.load(),800,600);

            Stage stage = new Stage();

        }catch(Exception e){
            e.printStackTrace();
        }

    }

}