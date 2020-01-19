package sample;

public class App {
    private BookList libraryBooks = new BookList();
    private UserList userList = new UserList();
    private AdminList adminList = new AdminList();
    private User currentUser;
    private Admin currentAdmin;

    public App(){
        adminList.addAdmin(new Admin("admin", "1234", "Barry"));
        libraryBooks.addBook(new Book("title1", "author1", "A great book"));
        userList.addUser(new User("somebody", "123", "Barry"));
        userList.addUser(new User("someone", "123", "Margaret"));
        userList.addUser(new User("bob", "123", "Roger"));
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
}
