package sample;

import java.io.File;
import java.util.List;

public class App {
    private BookList libraryBooks = new BookList();
    private UserList userList = new UserList();
    private AdminList adminList = new AdminList();
    private User currentUser;
    private Admin currentAdmin;


    public App(){
        if (new File("library_book.ser").isFile()){
            System.out.println("loading library_book");
            this.libraryBooks = (BookList) FileUtility.loadObject("library_book.ser");
        }
        if (new File("user_list.ser").isFile()){
            System.out.println("loading user_list");
            this.userList = (UserList) FileUtility.loadObject("user_list.ser");
        }
        // Serialize later
        adminList.addAdmin(new Admin("admin", "1234", "Alex"));
    }

    public BookList getLibraryBooks(){ return this.libraryBooks; }
    public UserList getUserList(){ return this.userList; }
    public AdminList getAdminList(){ return this.adminList; }
    public User getCurrentUser(){ return this.currentUser; }
    public void setCurrentUser(User currentUser){ this.currentUser = currentUser; }

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

    public boolean usernameIsUnique(String username){
        return (!userListContainsUserWithUsername(username) && !adminListContainsUserWithUsername(username));
    }

    public void sortLibraryBookByTitle(){
        this.libraryBooks.sortByTitle();
    }

    public void sortLibraryBookByAuthor(){
        this.libraryBooks.sortByAuthor();
    }

    public void shuffleLibraryBook(){
        this.libraryBooks.shuffleBook();
    }

    public boolean userListContainsUserWithUsername(String username){
        return this.userList.listContainsUserWithUsername(username);
    }

    public boolean adminListContainsUserWithUsername(String username){
        return this.adminList.listContainsAdminWithUsername(username);
    }

    public void addBookToLibrary(Book book){
        this.libraryBooks.addBook(book);
    }

    public void removeBookFromLibrary(Book book){
        this.libraryBooks.removeBook(book);
    }
}
