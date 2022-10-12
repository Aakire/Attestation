package Login;

public class User{
    private int id;
    private String login;
    private String email;
    private String password;
    private Role role;

    public User(int id, String login, String email, String password, Role role) {
        this.id = id;
        this.login = login;
        this.email = email;
        this.password = password;
        this.role = Role.valueOf(role.name());
    }
    public  User(){
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object obj) {
        User user = (User) obj;
        return (((this.login.equals(user.getLogin()))|
                (this.email.equals(user.getEmail())))&(this.password.equals(user.getPassword())));
    }

    @Override
    public String toString() {
        return
                "User №" + id +
                ", || login: " + login +
                ", || email: " + email +
                ", || password: " + password +
                ", || role: " + role.name() + "\n";
    }
}
