package pvt.banking.BankAccount;

import pvt.banking.Users.Users;
import pvt.banking.menu.ClientMenu;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.Serializable;

public class Account implements Serializable{
    private int id;
Currency currency;
private int numberAccount;
private int money;
    private static transient Scanner inNumber=new Scanner(System.in);
   private static transient Scanner inText=new Scanner(System.in);
    private static final long serialVersionUID =1l;

    public Account(int id,int numberAccount, Currency currency,int money) {
        this.id = id;
        this.numberAccount = numberAccount;
        this.currency = currency;
        this.money=money;
    }


    public static void createAccount(Users users) {
        List<Account> accountsList=deserializeAccount();
        int numberAccount =generateNumberAccount(accountsList);
        Currency cur=choiceCurrency();
        Account newAccount = new Account(users.getId(),numberAccount,cur,0);
        accountsList.add(newAccount);
        serializableAccount(accountsList);
    }


    public static void deleatedAccount(Users user) {
        outputInformation(user);
        List<Account> accounts=deserializeAccount();
        System.out.println("Введите номер счета который хотите удалить: ");
        int number = inNumber.nextInt();
        accounts.remove(searchByAccountNumber(accounts,number));
        serializableAccount(accounts);

    }


    public static void viewingTheBalanceOnAccounts(Users users) {
        outputInformation(users);
    }


    public void CalculationOfTheTotalAmountOnAccountsIn() {

    }


    public static void DepositingMoneyToTheAccount() {
        List<Account> accounts=deserializeAccount();
        System.out.println("Введите номер счета на который вносите деньги:");
        int number = inNumber.nextInt();
        System.out.println("Введите сумму:");
        number = inNumber.nextInt();
        accounts.get(searchByAccountNumber(accounts,number)).setMoney(number);
        serializableAccount(accounts);


    }
    private static int generateNumberAccount(List<Account> list){
        boolean flag=false;
        int i=0;
        int tempNumber= (int) (Math.random()*1000);
        do{
        for (Account a:list) {
            if(a.getNumberAccount()==tempNumber){
                i++;
            }
        }
        if(i>0){
            tempNumber= (int) (Math.random()*1000);
        }else{
            flag=true;
        }
        }while (!flag);
        return tempNumber;
    }


    public static Currency choiceCurrency() {
        System.out.println("Выберите валюту счета: BYN/EUR/USD/RUB ");
        String choice=inText.nextLine();
        switch (choice){
            case "BYN":
                return Currency.BYN;
            case "EUR":
                return Currency.EUR;
            case "USD":
                return Currency.USD;
            case "RUB":
                return Currency.RUB;
        }
        return null;
    }


    public static List<Account> serializableAccount(List<Account> accountList) {
        String file = "D:/javalessons/Mbanking/Ibanking/src/pvt/banking/data/AccountList.txt";
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file))){
            objectOutputStream.writeObject(accountList);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return accountList;
    }


    public static List<Account> deserializeAccount() {
        String file = "D:/javalessons/Mbanking/Ibanking/src/pvt/banking/data/AccountList.txt";
        List<Account> accountList =new ArrayList<>();
        try (ObjectInputStream objectInputputStream = new ObjectInputStream(new FileInputStream(file))) {
            accountList = ( List<Account>) objectInputputStream.readObject();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return accountList;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public int getNumberAccount() {
        return numberAccount;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void setNumberAccount(int numberAccount) {
        this.numberAccount = numberAccount;
    }
    public static void outputInformation(Users users){
        List<Account> account=Account.deserializeAccount();
        System.out.println(users.toString());
        for (Account a:account) {
            if(users.getId()==a.getId()){
                System.out.println(a.toString());
            }

        }}
    private static int searchByAccountNumber(List<Account> accounts, int number){
        int j=0;
        for(int i=0;i<accounts.size();i++){
            if(accounts.get(i).getNumberAccount()==number){
                j=i;
            }
        }
        return j;
    }


    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", numberAccount=" + numberAccount +
                ", currency=" + currency +
                ", money=" + money +
                '}';
    }
}
