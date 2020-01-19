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
import java.util.ResourceBundle;

public class ControllerUserScene {
    @FXML private ListView<Book> libraryListView;
    @FXML private ListView<Book> loanedBookListView;
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

    @FXML void loanSelectedBook(){
        System.out.println("Loan book");
        this.app.addBookToUserLoanedBookList(getSelectedBook());
    }

    @FXML
    public void initialize(URL url, ResourceBundle rb){
        System.out.println("hello");
    }

}
