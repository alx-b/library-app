package sample;

import java.io.Serializable;

public abstract class Person implements Serializable {
    private String username;
    private String password;
    private String name;
    //private String personNumber;

    public Person(String username, String password, String name) {
        this.username = username;
        this.password = password;
        this.name = name;
        //this.personNumber = personNumber;
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
        return "Username: " + username +
               "\nPassword: " + password +
               "\nName: " + name + "\n";
    }
}
