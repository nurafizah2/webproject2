package Model;
/**
 * @author Nurafizah
 */
public class client {
    private int id;
    private String username;
    private String password;
    private String role;

    public client() {
        super();
    }

    public client(int id, String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    
}
