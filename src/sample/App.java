package sample;

public class App {
    private BookList libraryBooks = new BookList();
    private UserList userList = new UserList();
    private AdminList adminList = new AdminList();

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
}
