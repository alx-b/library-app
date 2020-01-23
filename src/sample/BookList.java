package sample;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;

public class BookList implements Serializable {
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
        String regexPattern = Pattern.compile(".*" + title + ".*").pattern();
        for (Book book : this.books){
            if (book.getTitle().toLowerCase().matches(regexPattern.toLowerCase())){
                booksByTitle.add(book);
            }
        }
        return booksByTitle;
    }

    public List<Book> searchBookByAuthor(String author){
        List<Book> booksByAuthor = new ArrayList<>();
        String regexPattern = Pattern.compile(".*" + author + ".*").pattern();
        for (Book book : this.books){
            if (book.getAuthor().toLowerCase().matches(regexPattern.toLowerCase())){
                booksByAuthor.add(book);
            }
        }
        return booksByAuthor;
    }

    public void sortByTitle(){
        this.books.sort(Comparator.comparing(Book::getTitle));
    }


    public void sortByAuthor(){
        this.books.sort(Comparator.comparing(Book::getAuthor));
    }

    public void shuffleBook(){
        Collections.shuffle(this.books);
    }

    @Override
    public String toString() {
        return this.books + "\n";
    }
}
