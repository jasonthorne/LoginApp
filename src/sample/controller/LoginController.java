package sample.controller;



import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;


public class LoginController {

    //Contents below pasted from 'sample control skeleton' from 'Scene Builder'. +++++++++++++++++

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXTextField loginUserName;

    @FXML
    private JFXPasswordField loginPassword;

    @FXML
    private JFXButton loginBtn;



    @FXML
    void initialize() {
        //contents here were added manually!

        //change field font colours:
        ///loginUserName.setStyle("-fx-text-inner-color: #ffffff");
        ///loginPassword.setStyle("-fx-text-inner-color: #ffffff");

        loginBtn.setOnAction(new EventHandler<ActionEvent>() { //give button an event handler as its action
            @Override
            public void handle(ActionEvent event) {
                System.out.println("button clicked!");
            }
        });
    }
}
