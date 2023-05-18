package pvt.banking.BankAccount;

import java.util.List;
import java.util.Scanner;


public class TransferBetweenAccounts {
    static Scanner inNumber=new Scanner(System.in);
    public static void transferringMoneyToAnotherAccount(){
        List<Account> accountList=Account.deserializeAccount();
        System.out.println("Введите номер счета с которого будете переводить деньги:");
        int numberWith =inNumber.nextInt();
        System.out.println("Введите номер счета на который будете переводить деньги:");
        int numberIn=inNumber.nextInt();
        System.out.println("Введите сумму: ");
        int money=inNumber.nextInt();
        transfer(numberWith,numberIn,money,accountList);
        Account.serializableAccount(accountList);
    }
    private static void transfer(int numberWith, int numberIn, int money, List<Account> accountList){
     accountList.get(searchByAccountNumber(accountList,numberWith)).setMoney(accountList.get(searchByAccountNumber(accountList,numberWith)).getMoney()-money);
     accountList.get(searchByAccountNumber(accountList,numberIn)).setMoney(accountList.get(searchByAccountNumber(accountList,numberIn)).getMoney()+money/2);

    }
    private static int searchByAccountNumber(List<Account> accounts, int number){
        int j=0;
        for(int i=0;i<accounts.size();i++){
            if(accounts.get(i).getNumberAccount()==number){
                j=i;
            }
        }
        return j;
    }

}
