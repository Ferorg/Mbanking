package pvt.banking.menu;

import pvt.banking.BankAccount.Account;
import pvt.banking.BankAccount.TransferBetweenAccounts;
import pvt.banking.Users.Users;

import pvt.banking.massage.Massage;


import java.util.List;
import java.util.Scanner;

import static pvt.banking.Users.Users.changeLogin;
import static pvt.banking.Users.Users.changePaswword;
import static pvt.banking.serializableAndDeserializable.Deserializable.deserialize;


public class ClientMenu {
static boolean inMenu=true;
static Scanner in = new Scanner(System.in);


    public static void menuClient (Users users, List<Account> account){
        do{
            Account.outputInformation(users);
            Massage.clientMenuMessage();
            int choise = in.nextInt();
        switch (choise) {
            case 1:

                break;
            case 2:
                TransferBetweenAccounts.transferringMoneyToAnotherAccount();
                break;
            case 3:
                Account.viewingTheBalanceOnAccounts(users);
                break;
            case 4:
                break;
            case 5:
                Account.createAccount(users);
                break;
            case 6:
                Account.DepositingMoneyToTheAccount();
                break;
            case 7:
                Account.deleatedAccount(users);
                break;
            case 8:
                break;
            case 9:
                break;
            case 10:
                changePaswword(users);
                break;
            case 11:
                changeLogin(users);
                break;
            case 12:
                inMenu=false;
                break;
            default:
                //выбрасывать свое исключение
                break;
        }
        }while(inMenu);

    }


}

