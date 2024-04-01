package user;

import type.Role;

public class UserService {
    private User[] users;
    private int countOfUser;

    public UserService(int size){
        this.users = new User[size];
        users[0] = new User("Mansurbek","mansur07","1222", Role.ADMIN);
        users[1] = new User("Doniyor","doni","0527",Role.USER);
        countOfUser = 2;
    }

    public User getUsers(int size) {
        return users[size];
    }

    public void setUsers(User user) {
        this.users[countOfUser++] = user;
    }

    public int getCountOfUser() {
        return countOfUser;
    }

    public void setCountOfUser(int countOfUser) {
        this.countOfUser = countOfUser;
    }

    public User login(String username, String password) {
        for (int i = 0; i < countOfUser; i++) {
            User user = users[i];
            if (users[i]!=null && user.getUsername().equals(username)&&user.getPassword().equals(password) ){
                return user;
            }
        }
        return null;
    }

    public String showUserList() {
        String str  = "";
        for (int i = 0; i < countOfUser; i++) {
            User user = users[i];
            str += (i+1) + ". " + user.getName() + "  |  " + user.getRole() + "\n";
        }
        return  str;
    }

    public String signUp(String name, String username, String password) {
        User user = new User(name,username,password,Role.USER);
        setUsers(user);
        return  "User Added ✔";
    }
}
