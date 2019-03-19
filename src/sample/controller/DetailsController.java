package sample.controller;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;

public class DetailsController {


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label detailsWelcomeLbl;

    @FXML
    private Label detailsName;

    @FXML
    private Label detailsAge;

    @FXML
    private Label detailsProfession;

    @FXML
    private Hyperlink detailsGithub;

    @FXML
    private Hyperlink detailsLinkedIn;

    @FXML
    public void initialize() {

        //add action event listener handler to github link:
        detailsGithub.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println(detailsGithub.getText());

                if(Desktop.isDesktopSupported()){

                        //BOTH these try catches are needed!!
                        try {
                            try {
                                Desktop.getDesktop().browse(new URI("https://github.com/jasonthorne")); //create a new URI obj, to then pass inside our http
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }catch (URISyntaxException e) {
                            e.printStackTrace();
                        }


                }

            }
        });



    }

    public void setValues(String name, String profession, int age){
        detailsWelcomeLbl.setText("Welcome " + name);
        detailsName.setText("Name: " + name);
        detailsAge.setText("Age: " + String.valueOf(age)); //'String.valueOf(age' is converting the int to a String
        detailsProfession.setText("Profession: " + profession);
    }
}


