package sample;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class AdminSceneController {
    @FXML private ListView<Book> libraryListView;
    @FXML private ListView<User> userListView;
    @FXML private TextField titleField;
    @FXML private TextField authorField;
    @FXML private TextArea descriptionArea;
    @FXML private TextField byNameField;
    @FXML private Text bookListText;

    private App app;

    public AdminSceneController(App app) {
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
    protected void displayLoanedBooks(){
        this.libraryListView.getItems().clear();
        for (Book book : this.app.getLibraryBooks().getBooks()){
            if (!book.isAvailable()){
                this.libraryListView.getItems().add(book);
            }
        }
    }

    @FXML
    protected void addNewBook(){
        this.app.getLibraryBooks().addBook(new Book(this.titleField.getText(), this.authorField.getText(), this.descriptionArea.getText()));
        FileUtility.saveObject("library_book.ser", this.app.getLibraryBooks());
        displayBooks();
    }

    @FXML
    protected void removeSelectedBook(){
        this.app.getLibraryBooks().removeBook(getSelectedBook());
        FileUtility.saveObject("library_book.ser", this.app.getLibraryBooks());
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
    protected void searchUserByName(){
        List<User> users = this.app.searchUserByName(this.byNameField.getText());
        this.userListView.getItems().clear();
        for (User user : users){
            this.userListView.getItems().add(user);
        }

    }

    @FXML
    protected void displaySelectedUserLoanBookList(){
        this.bookListText.setText("");
        User user = this.userListView.getSelectionModel().getSelectedItem();
        List<Book> books = new ArrayList<>(user.getloanedBooks().getBooks());
        this.bookListText.setText(books.toString());
    }
/*
    @FXML
    public void initialize(URL url, ResourceBundle rb){
        System.out.println("hello");
    }
*/
}
