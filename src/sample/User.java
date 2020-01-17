package sample;

public class User extends Person {
    private BookList loanedBooks = new BookList();

    public User(String username, String password, String name, String personNumber){
        super(username, password, name, personNumber);
    }

    public void loanBook(Book book){
        book.markAsUnavailable();
        this.loanedBooks.addBook(book);
    }
}
