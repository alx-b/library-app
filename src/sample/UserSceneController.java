package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import java.util.List;

public class UserSceneController {
    @FXML private ListView<Book> libraryListView;
    @FXML private ListView<Book> loanedBookListView;
    @FXML private TextField searchField;
    @FXML private Text libraryBookDetailText;
    @FXML private Text loanedBookDetailText;
    @FXML private Text libraryInfoText;
    @FXML private Text loanBookInfoText;

    private App app;

    public UserSceneController(App app) {
        this.app = app;
    }

    @FXML
    private Book getSelectedBook(){
        return this.libraryListView.getSelectionModel().getSelectedItem();
    }

    @FXML
    private Book getSelectedLoanedBook(){
        return this.loanedBookListView.getSelectionModel().getSelectedItem();
    }

    private boolean loanedBookSelectionIsEmpty(){
        return this.loanedBookListView.getSelectionModel().isEmpty();
    }

    private boolean libraryBookSelectionIsEmpty(){
        return this.libraryListView.getSelectionModel().isEmpty();
    }

    @FXML
    private void displayBooks(){
        this.libraryListView.getItems().clear();
        this.libraryInfoText.setText("");
        for (Book book : this.app.getLibraryBooks().getBooks()){
            this.libraryListView.getItems().add(book);
        }
    }

    @FXML
    protected void sortLibraryBookByTitle(){
        this.app.sortLibraryBookByTitle();
        displayBooks();
    }

    @FXML
    protected void sortLibraryBookByAuthor(){
        this.app.sortLibraryBookByAuthor();
        displayBooks();
    }

    @FXML
    protected void shuffleLibraryBook(){
        this.app.shuffleLibraryBook();
        displayBooks();
    }

    @FXML
    protected void displayOnlyAvailableBooks(){
        this.libraryListView.getItems().clear();
        for (Book book : this.app.getLibraryBooks().getBooks()){
            if (book.isAvailable()){
                this.libraryListView.getItems().add(book);
            }
        }
    }

    @FXML
    protected void searchBookByTitle(){
        this.libraryListView.getItems().clear();
        if (this.searchField.getText().isBlank()){
            this.libraryInfoText.setText("* Fill in search field first.");
        } else {
            this.libraryInfoText.setText("");
            List<Book> books = this.app.searchBookByTitle(this.searchField.getText());
            for (Book book : books){
                this.libraryListView.getItems().add(book);
            }
        }
    }

    @FXML
    protected void searchBookByAuthor(){
        this.libraryListView.getItems().clear();
        if (this.searchField.getText().isBlank()){
            this.libraryInfoText.setText("* Fill in search field first.");
        } else {
            this.libraryInfoText.setText("");
            List<Book> books = this.app.searchBookByAuthor(this.searchField.getText());
            for (Book book : books){
                this.libraryListView.getItems().add(book);
            }
        }
    }


    @FXML
    protected void displayLoanedBooks(){
        this.loanedBookListView.getItems().clear();
        this.loanBookInfoText.setText("");
        for (Book book : this.app.getCurrentUser().getloanedBooks().getBooks()){
            this.loanedBookListView.getItems().add(book);
        }
    }

    @FXML
    protected void readMoreAboutSelectedBook(){
        if (libraryBookSelectionIsEmpty()) {
            this.libraryInfoText.setText("* Select a book first.");
        } else {
            Book book = getSelectedBook();
            this.libraryInfoText.setText("");
            this.libraryBookDetailText.setText(book.displayFullInfo());
        }
    }

    @FXML
    protected void readMoreAboutSelectedLoanedBook(){
        if (loanedBookSelectionIsEmpty()){
            this.loanBookInfoText.setText("* Select a book first.");
        } else {
            Book book = getSelectedLoanedBook();
            this.loanBookInfoText.setText("");
            this.loanedBookDetailText.setText(book.displayFullInfo());
        }
    }

    @FXML
    protected void returnSelectedBook(){
        if (loanedBookSelectionIsEmpty()){
            this.loanBookInfoText.setText("* Select a book first.");
        } else{
            int index = this.app.getLibraryBooks().getIndexOf(this.loanedBookListView.getSelectionModel().getSelectedItem());
            this.app.getLibraryBooks().getBooks().get(index).markAsAvailable();
            this.app.removeBookFromUserLoanedBookList(getSelectedLoanedBook());
            FileUtility.saveObject("library_book.ser", this.app.getLibraryBooks());
            FileUtility.saveObject("user_list.ser", this.app.getUserList());
            displayLoanedBooks();
            displayBooks();
        }
    }

    @FXML
    protected void loanSelectedBook(ActionEvent actionEvent){
        if (libraryBookSelectionIsEmpty()){
            this.libraryInfoText.setText("* Select a book first.");
        }
        else if (getSelectedBook().isAvailable()){
            this.app.addBookToUserLoanedBookList(getSelectedBook());
            FileUtility.saveObject("library_book.ser", this.app.getLibraryBooks());
            FileUtility.saveObject("user_list.ser", this.app.getUserList());
            displayLoanedBooks();
            displayBooks();
        } else{
            this.libraryInfoText.setText("* Selected book is unavailable.");
        }
    }
}
