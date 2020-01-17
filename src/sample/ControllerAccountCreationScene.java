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

public class ControllerAccountCreationScene {
    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private TextField nameField;
    @FXML private TextField personNumberField;
    private App app;

    public ControllerAccountCreationScene(App app) {
        this.app = app;
    }

    @FXML
    public void createAndAddAccount(){
        System.out.println("createAndAddAccount");
        this.app.getUserList().addUser(
                new User(usernameField.getText(), passwordField.getText(),
                nameField.getText(), personNumberField.getText())
        );
    }

    @FXML
    public void launchMainScene(ActionEvent actionEvent) throws IOException {
        System.out.println("AccountScene, launchMainScene");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("main.fxml"));
        loader.setController(new ControllerMain(this.app));
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
