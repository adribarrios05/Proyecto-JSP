package users;

public class User {
    private long id;
    private String username;
    private String email;
    private String password;


    public User(long id, String username, String email, String password){
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public long getId() {
        return id;
    }
    
    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return String.format("%s %s (%s)",getUsername(), getEmail(), getPassword());
    }
    
}
