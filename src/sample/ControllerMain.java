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

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerMain {
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    private App app;

    public ControllerMain(App app) {
        this.app = app;
    }

    @FXML
    public void launchCreateAccountScene(ActionEvent actionEvent) throws IOException {
        System.out.println("ControllerMain, launchCreateAccountScene");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("account-creation-scene.fxml"));
        loader.setController(new ControllerAccountCreationScene(this.app));
        Parent view = loader.load();
        Scene scene = new Scene(view, 800, 450);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    @FXML
    public void initialize(URL url, ResourceBundle rb){
        System.out.println("hello");
    }
}
