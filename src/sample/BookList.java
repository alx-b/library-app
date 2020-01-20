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

    public List<Book> searchBookByTitle(String title){
        List<Book> booksByTitle = new ArrayList<>();
        for (Book book : this.books){
            if (book.getTitle().toLowerCase().equals(title.toLowerCase())){
                booksByTitle.add(book);
            }
        }
        return booksByTitle;
    }

    public List<Book> searchBookByAuthor(String author){
        List<Book> booksByAuthor = new ArrayList<>();
        for (Book book : this.books){
            if (book.getAuthor().toLowerCase().equals(author.toLowerCase())){
                booksByAuthor.add(book);
            }
        }
        return booksByAuthor;
    }

    @Override
    public String toString() {
        return books + "\n";
    }
}
