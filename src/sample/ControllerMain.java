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

    public boolean usernameExistInUserList(){
        return this.app.getUserList().listContainsUserWithUsername(usernameField.getText());
    }

    public boolean usernameExistInAdminList(){
        return this.app.getAdminList().listContainsAdminWithUsername(usernameField.getText());
    }

    @FXML
    private void launchUserScene(ActionEvent actionEvent) throws IOException {
        System.out.println("ControllerMain, launchUserScene");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("user-scene.fxml"));
        loader.setController(new ControllerUserScene(this.app));
        Parent view = loader.load();
        Scene scene = new Scene(view, 800, 450);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    @FXML
    private void launchAdminScene(ActionEvent actionEvent) throws IOException {
        System.out.println("ControllerMain, launchAdminScene");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("admin-scene.fxml"));
        loader.setController(new ControllerAdminScene(this.app));
        Parent view = loader.load();
        Scene scene = new Scene(view, 800, 450);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    @FXML
    public void logIn(ActionEvent actionEvent) throws IOException {
        System.out.println("ControllerMain, logIn");
        if (usernameExistInUserList()){
            String userPassword = this.app.getUserList().getUserWithUsername(usernameField.getText()).getPassword();
            if (userPassword.equals(passwordField.getText())){
                launchUserScene(actionEvent);
            } else{
                //PASSWORD DOESNT MATCH
                System.out.println("PASS DOESNT MATCH");
            }
        } else if (usernameExistInAdminList()){
            String adminPassword = this.app.getAdminList().getAdminWithUsername(usernameField.getText()).getPassword();
            if (adminPassword.equals(passwordField.getText())){
                launchAdminScene(actionEvent);
            } else{
                //PASSWORD DOESNT MATCH
                System.out.println("PASS DOESNT MATCH");
            }
        }

        else{
            //USERNAME DOESNT EXIST
            System.out.println("USERNAME DOESNT EXIST");
        }
    }

    @FXML
    public void initialize(URL url, ResourceBundle rb){
        System.out.println("hello");
    }
}
