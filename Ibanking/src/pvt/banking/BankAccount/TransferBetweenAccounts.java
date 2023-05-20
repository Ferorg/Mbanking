package pvt.banking.BankAccount;

import pvt.banking.serializableAndDeserializable.ExchangeRate;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;


public class TransferBetweenAccounts {
    static Scanner inNumber = new Scanner(System.in);
    public static void curencyExchange(){
        List<Account> accountList = Account.deserializeAccount();
        System.out.println("Введите номер счета с которого будете переводить деньги:");
        int numberWith = inNumber.nextInt();
        System.out.println("Введите номер счета на который будете переводить деньги:");
        int numberIn = inNumber.nextInt();
        System.out.println("Введите сумму: ");
        int money = inNumber.nextInt();
        transfer(numberWith, numberIn, money, accountList);
        Account.serializableAccount(accountList);
    }

    public static void transferringMoneyToAnotherAccount() {
        List<Account> accountList = Account.deserializeAccount();
        System.out.println("Введите номер счета с которого будете переводить деньги:");
        int numberWith = inNumber.nextInt();
        System.out.println("Введите номер счета на который будете переводить деньги:");
        int numberIn = inNumber.nextInt();
        System.out.println("Введите сумму: ");
        int money = inNumber.nextInt();
        transfer(numberWith, numberIn, money, accountList);
        Account.serializableAccount(accountList);
    }

    private static void transfer(int numberWith, int numberIn, int money, List<Account> accountList) {
        accountList.get(searchByAccountNumber(accountList, numberWith)).setMoney(accountList.get(searchByAccountNumber(accountList, numberWith)).getMoney() - money);
       Double koef= searchTransferCoefficient(accountList, numberWith, numberIn);
        accountList.get(searchByAccountNumber(accountList, numberIn)).setMoney((int) ((int)accountList.get(searchByAccountNumber(accountList, numberIn)).getMoney() + money *koef));

    }

    private static int searchByAccountNumber(List<Account> accounts, int number) {
        int j = 0;
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getNumberAccount() == number) {
                j = i;
            }
        }
        return j;
    }

    //-------------------------------------
    public static Double searchTransferCoefficient(List<Account> accountList, int numberWith, int numberIn) {
        Set<Map.Entry<String, Double>> entrySet = ExchangeRate.deserializeCurrency();
        Double transferCoefficient = 0.0;
        if (accountList.get(searchByAccountNumber(accountList, numberWith)).getCurrency() == Currency.BYN) {
            switch (accountList.get(searchByAccountNumber(accountList, numberIn)).getCurrency()) {
                case BYN:
                    transferCoefficient = 1.0;
                    break;
                case RUB:
                    for (Map.Entry<String, Double> a : entrySet) {
                        if (a.getKey().equals("BYN/RUB")) {
                            transferCoefficient = a.getValue();
                        }
                    }
                    break;
                case USD:
                    for (Map.Entry<String, Double> a : entrySet) {
                        if (a.getKey().equals("BYN/USD")) {
                            transferCoefficient = a.getValue();
                        }
                    }
                    break;
                case EUR:
                    for (Map.Entry<String, Double> a : entrySet) {
                        if (a.getKey().equals("BYN/EUR")) {
                            transferCoefficient = a.getValue();
                        }
                    }
                    break;
            }
        } else if (accountList.get(searchByAccountNumber(accountList, numberWith)).getCurrency() == Currency.RUB) {
            switch (accountList.get(searchByAccountNumber(accountList, numberIn)).getCurrency()) {
                case BYN:
                    for (Map.Entry<String, Double> a : entrySet) {
                        if (a.getKey().equals("RUB/BYN")) {
                            transferCoefficient = a.getValue();
                        }
                    }
                    break;
                case RUB:
                    transferCoefficient = 1.0;
                    break;
                case USD:
                    for (Map.Entry<String, Double> a : entrySet) {
                        if (a.getKey().equals("RUB/USD")) {
                            transferCoefficient = a.getValue();
                        }
                    }
                    break;
                case EUR:
                    for (Map.Entry<String, Double> a : entrySet) {
                        if (a.getKey().equals("RUB/EUR")) {
                            transferCoefficient = a.getValue();
                        }
                    }
                    break;
            }
        } else if (accountList.get(searchByAccountNumber(accountList, numberWith)).getCurrency() == Currency.EUR) {
            switch (accountList.get(searchByAccountNumber(accountList, numberIn)).getCurrency()) {
                case BYN:
                    for (Map.Entry<String, Double> a : entrySet) {
                        if (a.getKey().equals("EUR/BYN")) {
                            transferCoefficient = a.getValue();
                        }
                    }
                    break;
                case RUB:
                    for (Map.Entry<String, Double> a : entrySet) {
                        if (a.getKey().equals("EUR/RUB")) {
                            transferCoefficient = a.getValue();
                        }
                    }
                    break;
                case USD:
                    for (Map.Entry<String, Double> a : entrySet) {
                        if (a.getKey().equals("EUR/USD")) {
                            transferCoefficient = a.getValue();
                        }
                    }
                    break;
                case EUR:
                    transferCoefficient = 1.0;
                    break;
            }
        } else if (accountList.get(searchByAccountNumber(accountList, numberWith)).getCurrency() == Currency.USD) {
            switch (accountList.get(searchByAccountNumber(accountList, numberIn)).getCurrency()) {
                case BYN:
                    for (Map.Entry<String, Double> a : entrySet) {
                        if (a.getKey().equals("USD/BYN")) {
                            transferCoefficient = a.getValue();
                        }
                    }
                    break;
                case RUB:
                    for (Map.Entry<String, Double> a : entrySet) {
                        if (a.getKey().equals("USD/RUB")) {
                            transferCoefficient = a.getValue();
                        }
                    }
                    break;
                case USD:
                    transferCoefficient = 1.0;
                    break;
                case EUR:
                    for (Map.Entry<String, Double> a : entrySet) {
                        if (a.getKey().equals("USD/EUR")) {
                            transferCoefficient = a.getValue();
                        }
                    }
                    break;
            }
        }
        return transferCoefficient;
    }
}
