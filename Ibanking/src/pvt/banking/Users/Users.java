package pvt.banking.Users;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Users implements Serializable {
    private int id;
    private String login;
    private int password;
    private String name;
    private Role role;
    private static List<Users> usersList=new ArrayList<>();

    public Users(int id, String login, int password,String name ,Role role) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.role = role;
        this.name=name;
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

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password=" + password +
                ", name='" + name + '\'' +
                ", role=" + role +
                '}';
    }







    @Override
    public int hashCode() {
        return Objects.hash(id, login, password);
    }
}

