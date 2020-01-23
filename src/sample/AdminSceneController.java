package sample;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;

public class AdminSceneController {
    @FXML private ListView<Book> libraryListView;
    @FXML private ListView<User> userListView;
    @FXML private TextField titleField;
    @FXML private TextField authorField;
    @FXML private TextArea descriptionArea;
    @FXML private TextField byNameField;
    @FXML private Text bookListText;
    @FXML private Text libraryInfoText;
    @FXML private Text addBookInfoText;
    @FXML private Text customerInfoText;

    private App app;

    public AdminSceneController(App app) {
        this.app = app;
    }

    private boolean fieldsAreBlank(){
        return (this.titleField.getText().isBlank() ||
                this.authorField.getText().isBlank() ||
                this.descriptionArea.getText().isBlank());
    }

    private void clearFields(){
        this.titleField.clear();
        this.authorField.clear();
        this.descriptionArea.clear();
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
        if (fieldsAreBlank()){
            this.addBookInfoText.setText("* Fill in all fields.");
        } else {
            this.app.addBookToLibrary(new Book(this.titleField.getText(), this.authorField.getText(), this.descriptionArea.getText()));
            clearFields();
            FileUtility.saveObject("library_book.ser", this.app.getLibraryBooks());
            displayBooks();
        }
    }

    @FXML
    protected void removeSelectedBook(){
        if (this.libraryListView.getSelectionModel().isEmpty()){
            this.libraryInfoText.setText("* Select a book to remove.");
        } else {
            this.app.removeBookFromLibrary(getSelectedBook());
            FileUtility.saveObject("library_book.ser", this.app.getLibraryBooks());
            displayBooks();
        }
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
        this.userListView.getItems().clear();
        if (this.byNameField.getText().isBlank()){
            this.customerInfoText.setText("* Fill in field first.");
        } else {
            this.customerInfoText.setText("");
            List<User> users = this.app.searchUserByName(this.byNameField.getText());
            for (User user : users){
                this.userListView.getItems().add(user);
            }
        }
    }

    @FXML
    protected void displaySelectedUserLoanBookList(){
        this.bookListText.setText("");
        if (this.userListView.getSelectionModel().isEmpty()){
            this.customerInfoText.setText("* Select a customer first.");
        } else{
            User user = this.userListView.getSelectionModel().getSelectedItem();
            List<Book> books = new ArrayList<>(user.getloanedBooks().getBooks());
            if (books.isEmpty()){
                this.bookListText.setText("* Customer has no loaned books.");
            } else{
                this.bookListText.setText(books.toString());
                customerInfoText.setText("");
            }
        }
    }
/*
    @FXML
    public void initialize(URL url, ResourceBundle rb){
        System.out.println("hello");
    }
*/
}
