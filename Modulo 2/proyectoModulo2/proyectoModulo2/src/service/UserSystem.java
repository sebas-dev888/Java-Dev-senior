package service;

import model.Role;
import model.User;

public class UserSystem {
    private User[] users;
    private int userCount;

    public UserSystem(int maxUsers, int userCount) {
        users = new User[maxUsers];
        this.userCount = userCount;
    }

    public boolean createUser(String id, String name, String username, String password, Role role) {
        if (findById(id) != null || findByUsername(username) != null || userCount >= users.length) {
            return false;
        }
        users[userCount++] = new User(username, id, name, password, role);
        return true;
    }

    public boolean createUser(User requester, String id, String name, String username, String password, Role role) {
        if (requester == null || requester.getRole() != Role.ADMIN) {
            return false;
        }
        boolean created = createUser(id, name, username, password, role);
        if (created) {
            requester.addAction("Created user " + username);
        }
        return created;
    }

    public User findById(String id) {
        for (int i = 0; i < userCount; i++) {
            if (users[i] != null && users[i].getIdUser().equals(id)) {
                return users[i];
            }
        }
        return null;
    }

    public User findByUsername(String username) {
        for (int i = 0; i < userCount; i++) {
            if (users[i] != null && users[i].getUsername().equals(username)) {
                return users[i];
            }
        }
        return null;
    }

    public boolean updateUser(User requester, String id, String newFullName, String newPassword, String currentPassword) {
        User user = findById(id);
        if (user == null) {
            return false;
        }
        if (requester == null) {
            return false;
        }
        if (requester.getRole() != Role.ADMIN && !requester.getIdUser().equals(id)) {
            return false;
        }
        boolean changed = false;
        if (newFullName != null && !newFullName.isBlank()) {
            user.setFullName(newFullName);
            changed = true;
        }
        if (newPassword != null && !newPassword.isBlank()) {
            if (requester.getRole() == Role.ADMIN && !requester.getIdUser().equals(id)) {
                user.setPassword(newPassword);
            } else if (!user.changePassword(currentPassword, newPassword)) {
                return false;
            }
            changed = true;
        }
        if (changed && requester.getRole() == Role.ADMIN) {
            requester.addAction("Updated user " + id);
        }
        return changed;
    }

    public boolean deleteUser(User requester, String id) {
        if (requester == null || requester.getRole() != Role.ADMIN) {
            return false;
        }
        for (int i = 0; i < userCount; i++) {
            if (users[i] != null && users[i].getIdUser().equals(id)) {
                for (int j = i; j < userCount - 1; j++) {
                    users[j] = users[j + 1];
                }
                users[--userCount] = null;
                requester.addAction("Deleted user " + id);
                return true;
            }
        }
        return false;
    }

    public User login(String username, String password) {
        User user = findByUsername(username);
        if (user != null && user.verifyPassword(password)) {
            user.addAction("Logged in");
            return user;
        }
        return null;
    }

    public void registerAction(User user, String description) {
        if (user != null) {
            user.addAction(description);
        }
    }
}
