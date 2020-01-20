package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginSceneController {
    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private Text infoText;
    private App app;

    public LoginSceneController(App app) {
        this.app = app;
    }

    @FXML
    protected void launchCreateAccountScene(ActionEvent actionEvent) throws IOException {
        System.out.println("LoginSceneController: launchCreateAccountScene");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/account-creation-scene.fxml"));
        loader.setController(new AccountCreationSceneController(this.app));
        Parent view = loader.load();
        Scene scene = new Scene(view, 800, 450);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    private boolean usernameExistInUserList(){
        return this.app.getUserList().listContainsUserWithUsername(usernameField.getText());
    }

    private boolean usernameExistInAdminList(){
        return this.app.getAdminList().listContainsAdminWithUsername(usernameField.getText());
    }

    private boolean fieldsAreEmpty(){
        return (this.usernameField.getText().equals("") ||
                this.passwordField.getText().equals(""));
    }

    @FXML
    protected void launchUserScene(ActionEvent actionEvent) throws IOException {
        System.out.println("LoginSceneController: launchUserScene");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/user-scene.fxml"));
        loader.setController(new UserSceneController(this.app));
        Parent view = loader.load();
        Scene scene = new Scene(view, 800, 450);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    @FXML
    protected void launchAdminScene(ActionEvent actionEvent) throws IOException {
        System.out.println("LoginSceneController: launchAdminScene");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/admin-scene.fxml"));
        loader.setController(new AdminSceneController(this.app));
        Parent view = loader.load();
        Scene scene = new Scene(view, 800, 450);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    @FXML
    protected void logIn(ActionEvent actionEvent) throws IOException {
        System.out.println("ControllerMain, logIn");
        if (usernameExistInUserList()){
            User currentUser = this.app.getUserList().getUserWithUsername(usernameField.getText());
            String userPassword = currentUser.getPassword();
            if (userPassword.equals(passwordField.getText())){
                this.app.setCurrentUser(currentUser);
                launchUserScene(actionEvent);
            } else{
                infoText.setText("* Password doesn't match.");
            }
        } else if (usernameExistInAdminList()){
            String adminPassword = this.app.getAdminList().getAdminWithUsername(usernameField.getText()).getPassword();
            if (adminPassword.equals(passwordField.getText())){
                launchAdminScene(actionEvent);
            } else{
                infoText.setText("* Password doesn't match.");
            }
        }

        else{
            infoText.setText("* Username doesn't exist.");
        }
    }
/*
    @FXML
    public void initialize(URL url, ResourceBundle rb){
        System.out.println("hello");
    }

*/
}
