package sample;

public class App {
    private BookList libraryBooks = new BookList();
    private UserList userList = new UserList();

    public BookList getLibraryBooks() {
        return this.libraryBooks;
    }

    public UserList getUserList(){
        return this.userList;
    }
}
