package com.yourapp.UserDAO;
import com.yourapp.Main.Main;
import com.yourapp.HabitStatistics.HabitStatistics;
import com.yourapp.User.User;

import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private List<User> users;

    public UserDAO() {
        this.users = new ArrayList<>();
    }

    public void registerUser (User user) {
        users.add(user);
    }

    public User loginUser(String email, String password) {
        for (User user : users) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public void editUserProfile(User user, String name, String email, String password) {
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
    }

    public void deleteUser(User user) {
        users.remove(user);
    }

    public List<User> getAllUsers() {
        return users;
    }
}

