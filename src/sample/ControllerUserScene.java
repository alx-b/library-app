package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerUserScene {
    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private TextField nameField;
    //@FXML private TextField personNumberField;
    private App app;

    public ControllerUserScene(App app) {
        this.app = app;
    }


    @FXML
    public void initialize(URL url, ResourceBundle rb){
        System.out.println("hello");
    }

}
