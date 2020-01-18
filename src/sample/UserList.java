package sample;

import java.util.ArrayList;
import java.util.List;

public class UserList {
    private List<User> users = new ArrayList<User>();

    public List<User> getUsers(){
        return this.users;
    }

    public void addUser(User user){
        this.users.add(user);
    }

    public boolean listContainsUserWithUsername(String username){
        for (User user : this.users){
            if (user.getUsername().equals(username)){
                return true;
            }
        }
        return false;
    }

    public User getUserWithUsername(String username){
        for (User user : this.users){
            if (user.getUsername().equals(username)){
                return user;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return users + "\n";
    }
}
