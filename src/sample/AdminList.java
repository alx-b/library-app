package sample;

import java.util.ArrayList;
import java.util.List;

public class AdminList {
    private List<Admin> admins = new ArrayList<Admin>();

    public void addAdmin(Admin admin){
        this.admins.add(admin);
    }

    public boolean listContainsAdminWithUsername(String username){
        for (Admin admin : this.admins){
            if (admin.getUsername().equals(username)){
                return true;
            }
        }
        return false;
    }

    public Admin getAdminWithUsername(String username){
        for (Admin admin : this.admins){
            if (admin.getUsername().equals(username)){
                return admin;
            }
        }
        return null;
    }
}
