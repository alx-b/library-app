package sample;

import java.util.List;

public class App {
    private BookList libraryBooks = new BookList();
    private UserList userList = new UserList();
    private AdminList adminList = new AdminList();
    private User currentUser;
    private Admin currentAdmin;

    public App(){
        adminList.addAdmin(new Admin("admin", "1234", "Barry"));
        libraryBooks.addBook(new Book("title1", "author1", "A great book"));
        libraryBooks.addBook(new Book("title2", "allo", "A great book2"));
        libraryBooks.addBook(new Book("clay", "author3", "A great book3"));
        libraryBooks.getBooks().get(1).markAsUnavailable();
        userList.addUser(new User("somebody", "123", "Barry"));
        userList.addUser(new User("someone", "123", "Margaret"));
        userList.addUser(new User("bob", "123", "Roger"));
        userList.getUsers().get(1).loanBook(libraryBooks.getBooks().get(2));
        userList.getUsers().get(1).loanBook(libraryBooks.getBooks().get(1));
    }

    public BookList getLibraryBooks() {
        return this.libraryBooks;
    }

    public UserList getUserList(){
        return this.userList;
    }
    public AdminList getAdminList(){ return this.adminList; }

    public User getCurrentUser(){
        return this.currentUser;
    }
    public void setCurrentUser(User currentUser){
        this.currentUser = currentUser;
    }

    public void addBookToUserLoanedBookList(Book book){
        this.currentUser.loanBook(book);
    }

    public void removeBookFromUserLoanedBookList(Book book){
        this.currentUser.returnBook(book);
    }

    public List<Book> searchBookByTitle(String title){
        return this.libraryBooks.searchBookByTitle(title);
    }

    public List<Book> searchBookByAuthor(String author){
        return this.libraryBooks.searchBookByAuthor(author);
    }

    public List<User> searchUserByName(String name){
        return this.userList.searchUserByName(name);
    }
}
