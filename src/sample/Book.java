package sample;

import java.io.Serializable;

public class Book implements Serializable {
    private String title;
    private String author;
    private String description;
    private boolean isAvailable = true;

    public Book(String title, String author, String description){
        this.title = title;
        this.author = author;
        this.description = description;
    }

    public String getTitle(){
        return this.title;
    }

    public String getAuthor(){
        return this.author;
    }

    public boolean isAvailable(){
        return this.isAvailable;
    }

    public void markAsUnavailable(){
        this.isAvailable = false;
    }

    public void markAsAvailable(){
        this.isAvailable = true;
    }

    public String displayFullInfo(){
        return "Title: " + this.title +
               "\n\nAuthor: " + this.author +
               "\n\nIs Available: " + this.isAvailable +
               "\n\nDescription: " + this.description + "\n";
    }

    @Override
    public String toString() {
        return "Title: " + title +
               "\nAuthor: " + author + "\n";
    }
}
