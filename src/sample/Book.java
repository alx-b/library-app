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

    public String getTitle(){
        return this.title;
    }

    public String getAuthor(){
        return this.author;
    }

    public boolean isAvailable(){
        return isAvailable;
    }

    public void markAsUnavailable(){
        this.isAvailable = false;
    }

    public void markAsAvailable(){
        this.isAvailable = true;
    }

    public String displayFullInfo(){
        return "Title: " + title +
               "\nAuthor: " + author +
               "\nDescription: " + description +
               "\nIs Available: " + isAvailable + "\n";
    }

    @Override
    public String toString() {
        return "Title: " + title +
               "\nAuthor: " + author + "\n";
    }
}
