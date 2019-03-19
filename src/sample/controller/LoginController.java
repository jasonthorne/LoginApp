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

            //create a loader object for FXML file:
            FXMLLoader loader = new FXMLLoader();

            //set the location from which we are loading the FXML file from:
            loader.setLocation(getClass().getResource("/sample/view/details.fxml"));


            try { //try catch needed here as loading is a potential fallover point

                //call the loaders load method:
                loader.load();

            } catch (IOException e) {
                e.printStackTrace();
            }

            //create an new root, giving it the path to FXML file (provided by 'loader': "/sample/view/details.fxml")
            Parent root = loader.getRoot();

            //create a new stage:
            Stage detailsStage = new Stage();

            //give the stage a new scene object, which is itself passed the root:
            detailsStage.setScene(new Scene(root));

            //====================Moving data from this controller to DetailsController

            //create a details controller obj (to then pass info from txt fields to):
            DetailsController detailsController = loader.getController(); //'loader' obj knows everything about 'details.xml'. '.getController' gets all of the details from it's contoller ('DetailsController' as referenced in 'details.fxml' 'anchorPane' tab).
            //These details include all of the labels such as 'detailsName', allowing them all to now be referenced.

            //now we have access to DetailsController, we can invoke it's PUBLIC 'setValues' method, and pass in whatever name the user has entered into 'loginUserName' textfield (above!)
            detailsController.setValues(loginUserName.getText().toString().trim(), "Graduate, in need of job!", 35);

            //====================


            //show the stage!! ++++
            detailsStage.show();

            //disallow resizing of window by user
            detailsStage.setResizable(false);


        }

    }
}
