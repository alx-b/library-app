package sample;

public class Book {
    private String title;
    private String author;
    private String description;
    private boolean isAvailable = true;

    public Book(String title, String author, String description){
        this.title = title;
        this.author = author;
        this.description = description;
    }

    public void markAsUnavailable(){
        this.isAvailable = false;
    }

    public void markAsAvailable(){
        this.isAvailable = true;
    }

    @Override
    public String toString() {
        return "Title: " + title +
               "Author: " + author +
               "Description: " + description +
               "Is Available: " + isAvailable + "\n";
    }
}
