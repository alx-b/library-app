package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ControllerUserScene {
    @FXML private ListView<Book> libraryListView;
    @FXML private ListView<Book> loanedBookListView;
    @FXML private TextField byTitleField;
    @FXML private TextField byAuthorField;

    private App app;

    public ControllerUserScene(App app) {
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

    @FXML
    protected void displayBooks(){
        this.libraryListView.getItems().clear();
        for (Book book : this.app.getLibraryBooks().getBooks()){
            this.libraryListView.getItems().add(book);
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
        System.out.println("readmoreabout...");
        Book book = getSelectedBook();
        System.out.println(book.displayFullInfo());
    }

    @FXML
    public void readMoreAboutSelectedLoanedBook(){
        Book book = getSelectedLoanedBook();
        System.out.println(book.displayFullInfo());
    }

    public void returnSelectedBook(){
        System.out.println("return book");
        this.app.removeBookFromUserLoanedBookList(getSelectedLoanedBook());
        displayLoanedBooks();
        displayBooks();
    }

    @FXML void loanSelectedBook(){
        System.out.println("Loan book");
        this.app.addBookToUserLoanedBookList(getSelectedBook());
        displayLoanedBooks();
        displayBooks();
    }

    @FXML
    public void initialize(URL url, ResourceBundle rb){
        System.out.println("hello");
    }

}
