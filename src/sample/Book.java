package sample;

public class Book {
    private String title;
    private String author;
    private String description;
    private boolean isAvailable = true;

    public Book(String title, String author, String description, boolean isAvailable=true){
        this.title = title;
        this.author = author;
        this.description = description;
    }


    @Override
    public String toString() {
        return "Title: " + title +
               "Author: " + author +
               "Description: " + description +
               "Is Available: " + isAvailable + "\n";
    }
}
