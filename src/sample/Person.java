package sample;

public abstract class Person {
    private String username;
    private String password;
    private String name;
    private String personNumber;

    public Person(String username, String password, String name, String personNumber) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.personNumber = personNumber;
    }
}
