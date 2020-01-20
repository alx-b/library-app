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
            if (user.getUsername().toLowerCase().equals(username.toLowerCase())){
                return user;
            }
        }
        return null;
    }

    public List<User> searchUserByName(String name){
        List<User> userByName = new ArrayList<>();
        for (User user : this.users){
            if (user.getName().toLowerCase().equals(name.toLowerCase())){
                userByName.add(user);
            }
        }
        return userByName;
    }

    @Override
    public String toString() {
        return users + "\n";
    }
}
