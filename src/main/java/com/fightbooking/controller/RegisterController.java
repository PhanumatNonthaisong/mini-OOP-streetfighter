package com.fightbooking.controller;

import com.fightbooking.model.User;
import com.fightbooking.service.UserService;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import java.util.UUID;

public class RegisterController {
	@FXML
	private TextField studentIdField;
    @FXML
    private TextField nameField;

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private ComboBox<String> typeBox;

    private UserService userService = UserService.getInstance();

    @FXML
    public void initialize(){

        typeBox.getItems().addAll("STUDENT","NORMAL");

        typeBox.setOnAction(e -> {

            String type = typeBox.getValue();

            if("STUDENT".equals(type)){

                studentIdField.setVisible(true);
                studentIdField.setManaged(true);

            }else{

                studentIdField.setVisible(false);
                studentIdField.setManaged(false);

            }

        });
    }
    private boolean isValidStudentId(String id){

        // pattern 9ตัว + - + 1ตัว
        return id.matches("\\d{9}-\\d");
    }

    @FXML
    private void handleRegister(){

        String name = nameField.getText();
        String email = emailField.getText();
        String password = passwordField.getText();
        String type = typeBox.getValue();
        String studentId = studentIdField.getText();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        // ถ้าเลือก student ต้องกรอกรหัส
        if("STUDENT".equals(type)){

            if(studentId == null || studentId.isEmpty()){
                alert.setContentText("Please enter student ID");
                alert.showAndWait();
                return;
            }

            if(!isValidStudentId(studentId)){
                alert.setContentText("Invalid student ID format (example: 683380089-3)");
                alert.showAndWait();
                return;
            }

        }

        User user = new User(
                UUID.randomUUID().toString(),
                name,
                email,
                password,
                type
        );

        boolean success = userService.register(user);

        if(success){
            alert.setContentText("Register success!");
        }else{
            alert.setContentText("Email already exists!");
        }

        alert.showAndWait();
    }

    @FXML
    private void goLogin() throws Exception{

        Stage stage = (Stage) nameField.getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/fxml/login.fxml")
        );

        Scene scene = new Scene(loader.load(),400,300);

        stage.setScene(scene);
    }
    
}