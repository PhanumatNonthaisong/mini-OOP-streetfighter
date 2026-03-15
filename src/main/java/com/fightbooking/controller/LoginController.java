package com.fightbooking.controller;

import com.fightbooking.model.User;
import com.fightbooking.service.UserService;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

public class LoginController {

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    private UserService userService = UserService.getInstance();

    // ⭐ METHOD LOGIN (ต้องมีตัวนี้)
    @FXML
    private void handleLogin() {

        String email = emailField.getText();
        String password = passwordField.getText();

        User user = userService.login(email, password);

        if(user == null){

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Invalid email or password");
            alert.showAndWait();
            return;

        }

        try{

            Stage stage = (Stage) emailField.getScene().getWindow();

            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/fxml/home.fxml")
            );

            Scene scene = new Scene(loader.load(),700,450);

            stage.setScene(scene);

        }catch(Exception e){
            e.printStackTrace();
        }

    }

    @FXML
    private void handleRegister() {

        try {

            Stage stage = (Stage) emailField.getScene().getWindow();

            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/fxml/register.fxml")
            );

            Scene scene = new Scene(loader.load(),400,350);

            stage.setScene(scene);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}