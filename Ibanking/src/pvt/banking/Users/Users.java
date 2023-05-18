package pvt.banking.Users;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import static pvt.banking.menu.AutorizationMenu.checkLogin;
import static pvt.banking.serializableAndDeserializable.Deserializable.deserialize;
import static pvt.banking.serializableAndDeserializable.Serializable.serializable;

public class Users implements Serializable {
    private int id;
    private String login;
    private int password;
    private String name;
    private Role role;
    private static final long serialVersionUID =1;
    private static List<Users> usersList=new ArrayList<>();

static Scanner inText =new Scanner(System.in);
static Scanner inNumber = new Scanner(System.in);
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
        return "\nUsers{" +
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
    public static void changeLogin(Users user){
        System.out.println("Введите новый логин: ");
        String newlogin=inText.nextLine();
        List<Users> usersList = deserialize();
        boolean flag = checkLogin( usersList,newlogin);
        try {
            if(!flag) {
                usersList.get(user.getId()).setLogin(newlogin);
                user.setLogin(newlogin);
                System.out.println(user.getLogin());
            }else{
                System.out.println("логин занят");
            }
        }catch (Throwable e) {
            e.printStackTrace();
        }
        serializable(usersList);
    }
    public static void changePaswword(Users user){
        System.out.println("Введите новый пароль: ");
        int newPassword=inNumber.nextInt();
        List<Users> usersList = deserialize();
        usersList.get(user.getId()).setPassword(newPassword);
        user.setPassword(newPassword);
        serializable(usersList);
    }
}

