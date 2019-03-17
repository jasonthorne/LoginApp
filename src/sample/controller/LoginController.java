package sample.controller;



import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


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

                System.out.println("login button clicked!");

                //invoke loginUser:
                loginUser();
            }
        });
    }

    private void loginUser(){

        //+++++++++++++IMPORTANT!!!
        //get the login window by targeting an element of it (loginBtn), and disable the window's visibility;
        loginBtn.getScene().getWindow().hide(); //Use the button to get the scene where the button resides, and use that to get the window, then call '.hide' on the window. (crazy!)

        if (!loginUserName.getText().toString().trim().equals("") //if username text field is NOT empty
                && !loginPassword.getText().toString().trim().equals(""));//AND password text field is NOT empty
        {

            //create a new stage:
            Stage detailsStage = new Stage();

            //create a new root from FXML file. Try Catch needed as its file reading, so possibly a fallover point:
            try{
                Parent root = FXMLLoader.load(getClass().getResource("/sample/view/details.fxml"));

                //create a new scene, and pass it the root:
                Scene scene = new Scene(root);

                //add the scene to the stage:
                detailsStage.setScene(scene);

                //show the stage!! ++++
                detailsStage.show();

                //disallow resizing of window by user
                detailsStage.setResizable(false);

            }catch (IOException e){

                e.printStackTrace();
            }

        }

    }
}
