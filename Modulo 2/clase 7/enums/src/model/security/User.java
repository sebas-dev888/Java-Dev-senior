package model.security;
public class User {
    private String name;
    private String email;
    private String password;
    private Boolean active;
    private UserRole role;


    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.active = true;
        this.role = UserRole.USER;
    }


    public User(String name, String email, String password, Boolean active, UserRole role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.active = active;
        this.role = role;
    }


    public String getName() {
        return name;
    }


    public String getEmail() {
        return email;
    }


    public String getPassword() {
        return password;
    }


    public Boolean getActive() {
        return active;
    }


    public UserRole getRole() {
        return role;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public void activateUser(){
        this.active = true;
    }

    public void desactivateUser(){
        this.active = false;
    }
    public void setRole(UserRole role){
        this.role = role;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return getName();
    }


    
}