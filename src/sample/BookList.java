package sample;

import java.util.ArrayList;
import java.util.List;

public class BookList {
    private List<Book> books = new ArrayList<Book>();

    public List<Book> getBooks(){
        return this.books;
    }

    public void addBook(Book book){
        this.books.add(book);
    }

    public void removeBook(Book book){
        this.books.remove(book);
    }

    public int getIndexOf(Book book){
        return this.books.indexOf(book);
    }

    @Override
    public String toString() {
        return books + "\n";
    }
}
