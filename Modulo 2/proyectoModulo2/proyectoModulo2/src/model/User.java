package model;

public class User {
    private String username;
    private String idUser;
    private String fullName;
    private String password;
    private Role role;
    private Action[] history;
    private int actionCount;

    public User(String username, String idUser, String fullName, String password, Role role) {
        this.username = username;
        this.idUser = idUser;
        this.fullName = fullName;
        this.password = password;
        this.role = role;
        this.history = new Action[100];
        this.actionCount = 0;
    }

    public String getUsername() {
        return username;
    }

    public String getIdUser() {
        return idUser;
    }

    public String getFullName() {
        return fullName;
    }

    public Role getRole() {
        return role;
    }

    public Action[] getHistory() {
        return history;
    }

    public int getActionCount() {
        return actionCount;
    }

    public String getPassword() {
        return password;
    }

    public Boolean verifyPassword(String pass) {
        return this.password.equals(pass);
    }

    public boolean changePassword(String current, String newPass) {
        if (!verifyPassword(current)) {
            return false;
        }
        this.password = newPass;
        addAction("Password changed");
        return true;
    }

    public void setPassword(String newPass) {
        this.password = newPass;
        addAction("Password changed by administrator");
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
        addAction("Profile name updated");
    }

    public void addAction(String description) {
        if (actionCount < history.length) {
            history[actionCount++] = new Action(description);
        }
    }

    public void showHistory() {
        if (actionCount == 0) {
            System.out.println("No action history available.");
            return;
        }
        System.out.println("History for " + fullName + ":");
        for (int i = 0; i < actionCount; i++) {
            System.out.println("- " + history[i]);
        }
    }
}
