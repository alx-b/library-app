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

public class AccountCreationSceneController {
    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private TextField nameField;
    @FXML private Text infoText;
    private App app;

    public AccountCreationSceneController(App app) {
        this.app = app;
    }

    private boolean fieldsAreBlank(){
        return (this.usernameField.getText().isBlank() ||
                this.passwordField.getText().isBlank() ||
                this.nameField.getText().isBlank());
    }

    @FXML
    protected void createAndAddAccount(){
        if (!fieldsAreBlank()){
            if (this.app.usernameIsUnique(this.usernameField.getText())){
                this.app.getUserList().addUser(
                        new User(
                                this.usernameField.getText(),
                                this.passwordField.getText(),
                                this.nameField.getText()
                        )
                );
                FileUtility.saveObject("user_list.ser", this.app.getUserList());
            } else{
                this.infoText.setText("* Username already exists.");
            }
        }
        else {
            this.infoText.setText("* Fill in all fields.");
        }
    }

    @FXML
    protected void launchMainScene(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/login-scene.fxml"));
        loader.setController(new LoginSceneController(this.app));
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
