package pl.coderslab.entity;



public class User {

    private Integer id;
    private String username;
    private String password;
    private String email;
    private Integer user_group_id;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getUser_group_id() {
        return user_group_id;
    }

    public void setUser_group_id(Integer user_group_id) {
        this.user_group_id = user_group_id;
    }

    @Override
    public String toString() {
        return  "\nid: " + id +
                "  | username: " + username +
                "  | password; " + password +
                "  | email: " + email+
                "  | user_group_id: " + user_group_id;
    }
}
