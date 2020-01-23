package sample;

import java.io.Serializable;

public abstract class Person implements Serializable {
    private String username;
    private String password;
    private String name;

    public Person(String username, String password, String name) {
        this.username = username;
        this.password = password;
        this.name = name;
    }

    public String getUsername(){
        return this.username;
    }
    public String getPassword(){
        return this.password;
    }
    public String getName() { return this.name; }

    @Override
    public String toString() {
        return "Username: " + this.username +
               "\nPassword: " + this.password +
               "\nName: " + this.name + "\n";
    }
}
