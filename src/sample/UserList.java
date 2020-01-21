package sample;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class UserList implements Serializable {
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
        String regexPattern = Pattern.compile(".*" + name + ".*").pattern();
        for (User user : this.users){
            if (user.getName().toLowerCase().matches(regexPattern.toLowerCase())){
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
