package pvt.banking;


import pvt.banking.BankAccount.Account;
import pvt.banking.BankAccount.Currency;
import pvt.banking.Users.Role;
import pvt.banking.Users.Users;
import pvt.banking.menu.AutorizationMenu;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import static pvt.banking.serializableAndDeserializable.Deserializable.deserialize;
import static pvt.banking.serializableAndDeserializable.Serializable.serializable;

public class Main {
    public static void main(String[] args) {

        List<Account> accounts = Account.deserializeAccount();
        List<Users> usersList = deserialize();
        System.out.print(usersList.toString());
        AutorizationMenu.menu1(usersList, accounts);




//        List<Account>accounts=new ArrayList<>();
//        Account.serializableAccount(accounts);
//        List<Users> usersList=new ArrayList<>();
//      temp(usersList);


    }

    public static void temp(List<Users> usersList) {
        usersList.clear();
        Users users = new Users(0, "ant", 123, "Anton", Role.Admin);
        usersList.add(users);
        serializable(usersList);
    }

}
