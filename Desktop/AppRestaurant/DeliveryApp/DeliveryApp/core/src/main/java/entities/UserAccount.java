package entities;

public class UserAccount {
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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private int id;

    private String username;

    // Type 1 for normal customer | 2 for deliveryman

    private int type;

    private String password;


    public UserAccount(int id, String username,int type, String password) {
        this.id = id;
        this.type = type;
        this.username = username;
        this.password = password;

    }


}
