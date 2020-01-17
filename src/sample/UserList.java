package sample;

import java.util.ArrayList;
import java.util.List;

public class UserList {
    private List<User> users = new ArrayList<User>();

    public void addUser(User user){
        this.users.add(user);
    }
}
