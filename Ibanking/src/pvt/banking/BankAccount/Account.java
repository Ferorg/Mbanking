package pvt.banking.BankAccount;

import pvt.banking.Users.Users;
import pvt.banking.menu.ClientMenu;
import pvt.banking.serializableAndDeserializable.ExchangeRate;

import java.io.*;
import java.util.*;
import java.io.Serializable;

import static pvt.banking.BankAccount.Currency.BYN;

public class Account implements Serializable {
    private int id;
    Currency currency;
    private int numberAccount;
    private int money;
    private static transient Scanner inNumber = new Scanner(System.in);
    private static transient Scanner inText = new Scanner(System.in);
    private static final long serialVersionUID = 1l;

    public Account(int id, int numberAccount, Currency currency, int money) {
        this.id = id;
        this.numberAccount = numberAccount;
        this.currency = currency;
        this.money = money;
    }


    public static void createAccount(Users users) {
        List<Account> accountsList = deserializeAccount();
        int numberAccount = generateNumberAccount(accountsList);
        Currency cur = choiceCurrency();
        Account newAccount = new Account(users.getId(), numberAccount, cur, 0);
        accountsList.add(newAccount);
        serializableAccount(accountsList);
    }


    public static void deleatedAccount(Users user) {
        List<Account> accounts = deserializeAccount();
        outputAccountIntformation(accounts, user);
        System.out.println("Введите номер счета который хотите удалить: ");
        int number = inNumber.nextInt();
        accounts.remove(searchByAccountNumber(accounts, number));
        serializableAccount(accounts);

    }


    public static void viewingTheBalanceOnAccounts(Users users) {
        outputInformation(users);
    }


    public static void CalculationOfTheTotalAmountOnAccountsIn(Users users) {
        List<Account> accounts = deserializeAccount();
        Double transferCoefficient = 0.0;
        int summ = 0;
        for (Account a : accounts) {
            if (a.getId() == users.getId()) {
                switch (a.getCurrency()) {
                    case BYN:
                        transferCoefficient = searchTransferCoefficient(Currency.BYN);
                        summ += a.getMoney() * transferCoefficient;
                        break;
                    case RUB:
                        transferCoefficient = searchTransferCoefficient(Currency.RUB);
                        summ += a.getMoney() * transferCoefficient;
                        break;
                    case EUR:
                        transferCoefficient = searchTransferCoefficient(Currency.EUR);
                        summ += a.getMoney() * transferCoefficient;
                        break;
                    case USD:
                        transferCoefficient = searchTransferCoefficient(Currency.USD);
                        summ += a.getMoney() * transferCoefficient;
                        break;
                }
            }

        }
        System.out.println("Общая сумма на счетах в BYN: " + summ);
    }

    public static Double searchTransferCoefficient(Currency currency) {
        Set<Map.Entry<String, Double>> entrySet = ExchangeRate.deserializeCurrency();
        Double transferCoefficient = 0.0;
        switch (currency) {
            case RUB:
                for (Map.Entry<String, Double> a : entrySet) {
                    if (a.getKey().equals("RUB/BYN")) {
                        transferCoefficient = a.getValue();
                    }
                }
                break;
            case BYN:
                transferCoefficient = 1.0;
                break;
            case EUR:
                for (Map.Entry<String, Double> a : entrySet) {
                    if (a.getKey().equals("EUR/BYN")) {
                        transferCoefficient = a.getValue();
                    }
                }
                break;
            case USD:
                for (Map.Entry<String, Double> a : entrySet) {
                    if (a.getKey().equals("USD/BYN")) {
                        transferCoefficient = a.getValue();
                    }
                }
                break;
        }


        return transferCoefficient;
    }


    public static void DepositingMoneyToTheAccount(Users user) {
        List<Account> accounts = deserializeAccount();
        outputAccountIntformation(accounts, user);
        System.out.println("Введите номер счета на который вносите деньги:");
        int number = inNumber.nextInt();
        System.out.println("Введите сумму:");
        int money = inNumber.nextInt();
        accounts.get(searchByAccountNumber(accounts, number)).setMoney(accounts.get(searchByAccountNumber(accounts, number)).getMoney()+money);
        serializableAccount(accounts);


    }

    private static int generateNumberAccount(List<Account> list) {
        boolean flag = false;
        int i = 0;
        int tempNumber = (int) (Math.random() * 1000);
        do {
            for (Account a : list) {
                if (a.getNumberAccount() == tempNumber) {
                    i++;
                }
            }
            if (i > 0) {
                tempNumber = (int) (Math.random() * 1000);
            } else {
                flag = true;
            }
        } while (!flag);
        return tempNumber;
    }


    public static Currency choiceCurrency() {
        System.out.println("Выберите валюту счета: BYN/EUR/USD/RUB ");
        String choice = inText.nextLine();
        switch (choice) {
            case "BYN":
                return BYN;
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
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file))) {
            objectOutputStream.writeObject(accountList);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return accountList;
    }


    public static List<Account> deserializeAccount() {
        String file = "D:/javalessons/Mbanking/Ibanking/src/pvt/banking/data/AccountList.txt";
        List<Account> accountList = new ArrayList<>();
        try (ObjectInputStream objectInputputStream = new ObjectInputStream(new FileInputStream(file))) {
            accountList = (List<Account>) objectInputputStream.readObject();
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

    public static void outputInformation(Users users) {
        List<Account> account = Account.deserializeAccount();
        System.out.println("\n-------------");
        System.out.println(users.toString());
        for (Account a : account) {
            if (users.getId() == a.getId()) {
                System.out.println(a.toString());
            }
        }
    }

    public static void outputAccountIntformation(List<Account> accounts, Users users) {
        for (Account a : accounts) {
            if (users.getId() == a.getId()) {
                System.out.println(a.toString());
            }
        }
    }

    public static int searchByAccountNumber(List<Account> accounts, int number) {
        int j = 0;
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getNumberAccount() == number) {
                j = i;
            }
        }
        return j;
    }


    @Override
    public String toString() {
        return "\nAccount{" +
                "id=" + id +
                ", numberAccount=" + numberAccount +
                ", currency=" + currency +
                ", money=" + money +
                '}';
    }

}
