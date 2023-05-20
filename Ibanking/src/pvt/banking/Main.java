package pvt.banking;


import pvt.banking.BankAccount.Account;
import pvt.banking.BankAccount.Currency;
import pvt.banking.Users.Role;
import pvt.banking.Users.Users;
import pvt.banking.menu.AdminMenu;
import pvt.banking.menu.AutorizationMenu;
import pvt.banking.serializableAndDeserializable.ExchangeRate;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

import static pvt.banking.serializableAndDeserializable.Deserializable.deserialize;
import static pvt.banking.serializableAndDeserializable.Serializable.serializable;

public class Main {
    public static void main(String[] args) {

//        List<Account> accounts = Account.deserializeAccount();
//        List<Users> usersList = deserialize();
//        Set<Map.Entry<String,Double>> entrySet= ExchangeRate.deserializeCurrency();
//        System.out.print(usersList.toString());
//        AutorizationMenu.menu1(usersList, accounts);




//        List<Account>accounts=new ArrayList<>();
//        List<Users> usersList=new ArrayList<>();
//      temp(usersList,accounts);
//        System.out.println(usersList.toString());
//        System.out.println(accounts.toString());
        AdminMenu.addKurslist();
        Set<Map.Entry<String,Double>> entrySet= ExchangeRate.deserializeCurrency();
        for (Map.Entry<String,Double> m:entrySet) {
            System.out.println(m.toString());

        }
    }

    public static void temp(List<Users> usersList,List<Account> accounts) {
       // usersList.clear();
        Users users = new Users(0, "ant", 123, "Anton", Role.Admin);
        usersList.add(users);
        serializable(usersList);
      //  accounts.clear();
        Account penia=new Account(999,1,Currency.BYN,0);
        accounts.add(penia);
        Account.serializableAccount(accounts);
    }

}
