package sample;

public abstract class Person {
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
}
