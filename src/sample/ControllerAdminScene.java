package sample;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerAdminScene {
    @FXML private ListView<Book> libraryListView;
    @FXML private ListView<User> userListView;
    @FXML private TextField titleField;
    @FXML private TextField authorField;
    @FXML private TextField descriptionField;

    private App app;

    public ControllerAdminScene(App app) {
        this.app = app;
    }


    @FXML
    private Book getSelectedBook(){
        return this.libraryListView.getSelectionModel().getSelectedItem();
    }

    @FXML
    protected void displayBooks(){
        this.libraryListView.getItems().clear();
        for (Book book : this.app.getLibraryBooks().getBooks()){
            this.libraryListView.getItems().add(book);
        }
    }

    @FXML
    protected void addNewBook(){
        this.app.getLibraryBooks().addBook(new Book(this.titleField.getText(), this.authorField.getText(), this.descriptionField.getText()));
        displayBooks();
    }

    @FXML
    protected void removeSelectedBook(){
        this.app.getLibraryBooks().removeBook(getSelectedBook());
        displayBooks();
    }

    @FXML
    protected void displayUsers(){
        this.userListView.getItems().clear();
        for (User user : this.app.getUserList().getUsers()){
            this.userListView.getItems().add(user);
        }
    }

    @FXML
    public void initialize(URL url, ResourceBundle rb){
        System.out.println("hello");
    }

}
