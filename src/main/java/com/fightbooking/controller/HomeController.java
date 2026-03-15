package com.fightbooking.controller;

import com.fightbooking.model.Event;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class HomeController {

    @FXML
    private TableView<Event> eventTable;

    @FXML
    private TableColumn<Event,String> fightColumn;

    @FXML
    private TableColumn<Event,String> dateColumn;

    @FXML
    private TableColumn<Event,String> venueColumn;

    @FXML
    private TableColumn<Event,Double> priceColumn;

    @FXML
    private TableColumn<Event,Void> actionColumn;

    private ObservableList<Event> events =
            FXCollections.observableArrayList();

    @FXML
    public void initialize(){

        fightColumn.setCellValueFactory(
                new PropertyValueFactory<>("name")
        );

        dateColumn.setCellValueFactory(
                new PropertyValueFactory<>("date")
        );

        venueColumn.setCellValueFactory(
                new PropertyValueFactory<>("venue")
        );

        priceColumn.setCellValueFactory(
                new PropertyValueFactory<>("price")
        );

        loadEvents();
        eventTable.setItems(events);

        addButtonToTable();

    }

    private void loadEvents(){

        events.add(new Event(
                "KKU Fight Night",
                "20 July 2025",
                "KKU Arena",
                500
        ));

        events.add(new Event(
                "Bangkok Street Fight",
                "21 July 2025",
                "Bangkok Arena",
                600
        ));

        events.add(new Event(
                "Thailand Championship",
                "22 July 2025",
                "National Stadium",
                700
        ));

    }

    private void addButtonToTable() {

        actionColumn.setCellFactory(param -> new TableCell<>() {

            private final Button btn = new Button("ดูรายละเอียด");

            {
                btn.setStyle("-fx-background-color:#ef4444; -fx-text-fill:white;");
                btn.setOnAction(event -> {

                    Event data = getTableView().getItems().get(getIndex());

                    openEventDetail(data);

                });
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    setGraphic(btn);
                }
            }
        });

    }

    private void openEventDetail(Event event){

        try{

            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/fxml/eventDetail.fxml")
            );

            Scene scene = new Scene(loader.load(),1000,600);

            Stage stage = (Stage) eventTable.getScene().getWindow();

            stage.setScene(scene);

        }catch(Exception e){
            e.printStackTrace();
        }

    }

}