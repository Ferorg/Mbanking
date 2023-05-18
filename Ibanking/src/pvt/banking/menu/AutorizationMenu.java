package pvt.banking.menu;

import pvt.banking.BankAccount.Account;
import pvt.banking.Users.Role;
import pvt.banking.Users.Users;
import pvt.banking.massage.Massage;

import java.util.List;
import java.util.Scanner;

import static pvt.banking.massage.Massage.exitMessage;
import static pvt.banking.menu.AdminMenu.menuAdmin;
import static pvt.banking.menu.ClientMenu.menuClient;
import static pvt.banking.serializableAndDeserializable.Deserializable.deserialize;
import static pvt.banking.serializableAndDeserializable.Serializable.serializable;


public class AutorizationMenu {
    static boolean inMenu=true;
    static Scanner in = new Scanner(System.in);
    static Scanner inNumber=new Scanner(System.in);
    static Scanner inText=new Scanner(System.in);
    public static void menu1(List<Users> usersList,List<Account> ac){
        do {
            Massage.autorizationMenuMessage();
            int choise = in.nextInt();
    switch (choise){
        case 1:
            System.out.println("Авторизация.");
            autorizationClient(usersList,ac);
          //  inMenu=false;
            break;
        case 2:
            System.out.println("Регистрация нового пользователя.");
            registrationClient(usersList);
            break;
        case 3:
            exitMessage();
            inMenu=false;
            break;
        default:
            //выбрасывать свое исключение
            break;
    }}while(inMenu);
    }
    public static void registrationClient(List<Users> users){
        System.out.println("Введите логин");
        String login = inText.nextLine();
        System.out.println("Введите пароль");
        int parol = inNumber.nextInt();
        System.out.println("Введите имя");
        String name = inText.nextLine();
        Users user=new Users(0,login,parol,name,Role.Client);
        registrationClient(users,user);
        serializable(users);
    }
    public static   void autorizationClient(List<Users> users,List<Account> ac){
        System.out.println("Введите логин");
        String login = inText.nextLine();
        System.out.println("Введите пароль");
        int parol = inNumber.nextInt();
        clientAvailabilityCheck(users,login,parol,ac);

    }
    public static void clientAvailabilityCheck(List<Users>  users,String login,int parol,List<Account> ac){
        int i=0;
        for (Users u:users) {
            if((login.equals(u.getLogin()))&&(parol==u.getPassword())){
                checkRoleAndChoiseMenu(u,ac);

            }else{
                i++;
            }
        }
        if(i>0){
            System.out.println("неверный логин или пароль");
        }
    }
    public static void checkRoleAndChoiseMenu(Users users, List<Account> ac){
        if(users.getRole().equals(Role.Admin)){
            System.out.println(users.getName()+" Добро пожаловать ");
            menuAdmin (users);
        }else{
            System.out.println(users.getName()+" Добро пожаловать ");
            menuClient(users,ac);
        }
    }
public static List<Users> registrationClient(List<Users> users, Users user){
    //проверка логина

    String login=user.getLogin();
    boolean flag = checkLogin( users,login);
    try {
        if(!flag) {
            users.add(user);
        }else{
            System.out.println("логин занят");
        }
    }catch (Throwable e) {
        e.printStackTrace();
    }

    for(int i=0;i< users.size();i++){
        users.get(i).setId(i);
    }
    return users;
}
public static boolean checkLogin(List<Users> users, String login){
    boolean flag=false;
    for (Users u:users) {
        if(u.getLogin().equals(login)){
            flag=true;
            break;
        }else{
            flag=false;
        }
    }
    return flag;
}
}
