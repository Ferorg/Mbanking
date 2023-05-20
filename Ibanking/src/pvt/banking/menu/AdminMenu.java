package pvt.banking.menu;

import pvt.banking.BankAccount.Account;
import pvt.banking.Users.Role;
import pvt.banking.Users.Users;
import pvt.banking.massage.Massage;
import pvt.banking.serializableAndDeserializable.ExchangeRate;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.*;

import static pvt.banking.BankAccount.Account.outputInformation;
import static pvt.banking.Users.Users.changeLogin;
import static pvt.banking.Users.Users.changePaswword;
import static pvt.banking.menu.AutorizationMenu.*;
import static pvt.banking.serializableAndDeserializable.Deserializable.deserialize;
import static pvt.banking.serializableAndDeserializable.Serializable.serializable;


public class AdminMenu {
    static boolean inMenu=true;
    static Scanner in = new Scanner(System.in);
    public static void menuAdmin (Users users){
        do{
            outputInformation(users);
            Massage.adminMenuMessage();
            int choise = in.nextInt();
            switch (choise) {
                case 1:
                    System.out.println(11);
                    break;
                case 2:
                    showAllClient();
                    break;
                case 3:
                    System.out.println(33);
                    break;
                case 4:
                    deletedClient();
                    break;
                case 5:
                    Account.createAccount(users);
                    break;
                case 6:
                    viewAccountWithCommissions();
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    registrationClient();
                    break;
                case 11:
                    viewClientByEnterLogin();
                    break;
                case 12:
                    showAllAccount();
                    break;
                case 13:
                    break;
                case 14:
                    break;
                case 15:
                    changePaswword(users);
                    break;
                case 16:
                    changeLogin(users);
                    break;
                case 17:
                    inMenu=false;
                    break;
                default:
                    //выбрасывать свое исключение
                    break;
            }
        }while(inMenu);

    }
    public static void showAllClient(){
        List<Users> usersList = deserialize();
        System.out.print(usersList.toString());

    }
    public static void showAllAccount(){
        //сделать сортировку по id
        List<Account> accountsList = Account.deserializeAccount();
        System.out.println(accountsList.toString());

    }
    public static void registrationClient(){
        List<Users>users = deserialize();
        System.out.println("Введите логин");
        String login = inText.nextLine();
        System.out.println("Введите пароль");
        int parol = inNumber.nextInt();
        System.out.println("Введите имя");
        String name = inText.nextLine();
        System.out.println("установите роль пользователя: client/admin");
        String role = inText.nextLine();
        Users user=new Users(0,login,parol,name,changeRole(role));
        registrationClient1(users,user);
        serializable(users);
    }
    public static Role changeRole(String role){
        role=role.toLowerCase();
        Role temp=null;
        switch (role){
            case "client":
                temp=Role.Client;
                break;
            case"admin":
                temp= Role.Admin;
                break;
        }
        return temp;
    }
    public static void deletedClient(){
        List<Users>users = deserialize();
        List<Account> accountsList = Account.deserializeAccount();
        System.out.println("Введите логин клиента которого хотите удалить:");
        String name=inText.nextLine().toLowerCase();
        int tempId=0;
        for (Users u:users) {
            if(u.getLogin().toLowerCase().equals(name)){
                tempId=u.getId();
            }
        }
        for (Account a:accountsList) {
            if(a.getId()==tempId){
                int j=a.getNumberAccount();
                accountsList.remove(Account.searchByAccountNumber(accountsList, j));

            }

        }
        users.remove(searchByUsersId( users,tempId));
        idRecalculating(users);
        serializable(users);
        Account.serializableAccount(accountsList);
    }
//    private static int searchByAccountId(List<Account> accounts, int tempId) {
//        int j = 0;
//        for (int i = 0; i < accounts.size(); i++) {
//            if (accounts.get(i).getId() == tempId) {
//                j = i;
//            }
//        }
//        return j;
//    }
    private static int searchByUsersId(List<Users> usersList, int tempId) {
        int j = 0;
        for (int i = 0; i < usersList.size(); i++) {
            if (usersList.get(i).getId() == tempId) {
                j = i;
            }
        }
        return j;
    }

    public static void viewClientByEnterLogin(){
        List<Users>users = deserialize();
        List<Account> accountsList = Account.deserializeAccount();
        System.out.println("Введите логин клиента: ");
        String log=inText.nextLine();
        viewClientByLogin(log,users,accountsList);


    }
    public static void viewClientByLogin(String log,List<Users>users, List<Account> accountsList){
int tempID=0;
        for (Users u:users) {
            if(u.getLogin().equals(log)){
                tempID=u.getId();
                System.out.println(u.toString());
            }
        }
        for (Account a:accountsList) {
            if(a.getId()==tempID){
                System.out.println(a.toString());
            }

        }
    }
    public static void viewAccountWithCommissions(){
        List<Account> accountsList = Account.deserializeAccount();
        int tempId=999;
        for (Account a:accountsList) {
            if(a.getId()==tempId){
                System.out.println( a.toString());
            }
        }
        Account.serializableAccount(accountsList);
    }
    public static void addKurslist(){
        System.out.println("Введите адрес нового файла: ");
        String file=inText.nextLine();
        Map<String, Double> currency = new HashMap<>();
        try (ObjectInputStream objectInputputStream = new ObjectInputStream(new FileInputStream(file))) {
            currency = (Map<String, Double>) objectInputputStream.readObject();
            objectInputputStream.close();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        //Set<Map.Entry<String,Double>> entrySet=currency.entrySet();
        ExchangeRate.serializableValuet(currency);
    }
}
