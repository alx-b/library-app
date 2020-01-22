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
        FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/account-creation-scene.fxml"));
        loader.setController(new AccountCreationSceneController(this.app));
        launchScene(actionEvent, loader);
    }

    @FXML
    protected void launchUserScene(ActionEvent actionEvent) throws IOException {
        System.out.println("LoginSceneController: launchUserScene");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/user-scene.fxml"));
        loader.setController(new UserSceneController(this.app));
        launchScene(actionEvent, loader);
    }

    @FXML
    protected void launchAdminScene(ActionEvent actionEvent) throws IOException {
        System.out.println("LoginSceneController: launchAdminScene");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/admin-scene.fxml"));
        loader.setController(new AdminSceneController(this.app));
        launchScene(actionEvent, loader);
    }

    @FXML
    protected void logIn(ActionEvent actionEvent) throws IOException {
        if (fieldsAreBlank()){
            this.infoText.setText("* Fill in all fields.");
        } else{
            if (usernameExistInUserList()){
                User currentUser = this.app.getUserList().getUserWithUsername(this.usernameField.getText());
                String userPassword = currentUser.getPassword();
                if (userPassword.equals(this.passwordField.getText())){
                    this.app.setCurrentUser(currentUser);
                    launchUserScene(actionEvent);
                } else{
                    this.infoText.setText("* Password doesn't match.");
                }
            } else if (usernameExistInAdminList()){
                String adminPassword = this.app.getAdminList().getAdminWithUsername(this.usernameField.getText()).getPassword();
                if (adminPassword.equals(this.passwordField.getText())){
                    launchAdminScene(actionEvent);
                } else{
                    this.infoText.setText("* Password doesn't match.");
                }
            } else{
                this.infoText.setText("* Username doesn't exist.");
            }
        }
    }

    private boolean usernameExistInUserList(){
        return this.app.getUserList().listContainsUserWithUsername(this.usernameField.getText());
    }

    private boolean usernameExistInAdminList(){
        return this.app.getAdminList().listContainsAdminWithUsername(this.usernameField.getText());
    }

    private boolean fieldsAreBlank(){
        return (this.usernameField.getText().isBlank() ||
                this.passwordField.getText().isBlank());
    }

    @FXML
    private void launchScene(ActionEvent actionEvent, FXMLLoader loader) throws IOException {
        Parent view = loader.load();
        Scene scene = new Scene(view, 800, 450);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

/*
    @FXML
    public void initialize(URL url, ResourceBundle rb){
        System.out.println("hello");
    }

*/
}
