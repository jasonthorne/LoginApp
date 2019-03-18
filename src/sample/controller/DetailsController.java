package sample.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
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
    private Label detailsGithub;

    @FXML
    private Label detailsLinkedIn;

    @FXML
    public void initialize() {



    }

    public void setName(String name){
        detailsWelcomeLbl.setText("Welcome " + name);
        detailsName.setText(name);
    }
}


