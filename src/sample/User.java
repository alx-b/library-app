package sample;

import java.io.Serializable;

public class User extends Person {
    private BookList loanedBooks = new BookList();

    public User(String username, String password, String name){
        super(username, password, name);
    }

    public BookList getloanedBooks(){
        return this.loanedBooks;
    }

    public void loanBook(Book book){
        book.markAsUnavailable();
        this.loanedBooks.addBook(book);
    }

    public void returnBook(Book book){
        book.markAsAvailable();
        this.loanedBooks.removeBook(book);
    }
}
