package model.sales;

public class user {
    private String name;
    private Boolean active;
    public user(String name, Boolean active) {
        this.name = name;
        this.active = active;
    }
    public String getName() {
        return name;
    }
    public Boolean getActive() {
        return active;
    }
    
}
