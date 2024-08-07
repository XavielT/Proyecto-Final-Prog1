package service;

import model.User;
import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private List<User> users = new ArrayList<>();

    // Singleton para la gestión de usuarios
    private static UserManager instance;

    private UserManager() {}

    public static UserManager getInstance() {
        if (instance == null) {
            instance = new UserManager();
        }
        return instance;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public User findUserByUsername(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public List<User> getAllUsers() {
        return users;
    }

    public void updateUser(User user) {
        // Implementación para actualizar el usuario
    }

    public void deleteUser(User user) {
        users.remove(user);
    }

    public boolean validateLogin(String username, String password) {
        User user = findUserByUsername(username);
        return user != null && user.getPassword().equals(password);
    }
}

