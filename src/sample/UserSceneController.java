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
    @FXML private TextField byTitleField;
    @FXML private TextField byAuthorField;
    @FXML private Text libraryBookDetailText;
    @FXML private Text loanedBookDetailText;

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
        return loanedBookListView.getSelectionModel().isEmpty();
    }

    private boolean libraryBookSelectionIsEmpty(){
        return libraryListView.getSelectionModel().isEmpty();
    }

    @FXML
    protected void displayBooks(){
        this.libraryListView.getItems().clear();
        for (Book book : this.app.getLibraryBooks().getBooks()){
            this.libraryListView.getItems().add(book);
        }
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
        List<Book> books = this.app.searchBookByTitle(this.byTitleField.getText());
        this.libraryListView.getItems().clear();
        for (Book book : books){
            this.libraryListView.getItems().add(book);
        }
    }


    @FXML
    protected void searchBookByAuthor(){
        List<Book> books = this.app.searchBookByAuthor(this.byAuthorField.getText());
        this.libraryListView.getItems().clear();
        for (Book book : books){
            this.libraryListView.getItems().add(book);
        }
    }


    @FXML
    protected void displayLoanedBooks(){
        this.loanedBookListView.getItems().clear();
        for (Book book : this.app.getCurrentUser().getloanedBooks().getBooks()){
            this.loanedBookListView.getItems().add(book);
        }
    }

    @FXML
    public void readMoreAboutSelectedBook(){
        if (libraryBookSelectionIsEmpty()) {
            System.out.println("you haven't select a book.");
        } else {
            Book book = getSelectedBook();
            libraryBookDetailText.setText(book.displayFullInfo());
        }
    }

    @FXML
    public void readMoreAboutSelectedLoanedBook(){
        if (loanedBookSelectionIsEmpty()){
            System.out.println("you haven't select a book.");
        } else {
            Book book = getSelectedLoanedBook();
            //System.out.println(book.displayFullInfo());
            loanedBookDetailText.setText(book.displayFullInfo());
        }
    }

    public void returnSelectedBook(){
        System.out.println("return book");
        if (loanedBookSelectionIsEmpty()){
            System.out.println("you haven't select a book to return.");
        } else{
            int index = this.app.getLibraryBooks().getIndexOf(loanedBookListView.getSelectionModel().getSelectedItem());
            this.app.getLibraryBooks().getBooks().get(index).markAsAvailable();
            this.app.removeBookFromUserLoanedBookList(getSelectedLoanedBook());
            FileUtility.saveObject("library_book.ser", this.app.getLibraryBooks());
            FileUtility.saveObject("user_list.ser", this.app.getUserList());
        }
        displayLoanedBooks();
        displayBooks();
    }

    @FXML void loanSelectedBook(ActionEvent actionEvent){
        if (!libraryBookSelectionIsEmpty() && getSelectedBook().isAvailable()){
            System.out.println("Loan book");
            this.app.addBookToUserLoanedBookList(getSelectedBook());
            FileUtility.saveObject("library_book.ser", this.app.getLibraryBooks());
            FileUtility.saveObject("user_list.ser", this.app.getUserList());
        } else{
            System.out.println("can't loan book");
        }
        displayLoanedBooks();
        displayBooks();
    }
/*
    @FXML
    public void initialize(URL url, ResourceBundle rb){
        System.out.println("hello");
    }
*/
}
