package pvt.banking.massage;

public class Massage {

    public static void clientMenuMessage(){
        System.out.println("\n1)Обмен валюты. \n2)Перевод средств на другой счет. \n3)Просмотр баланса на счетах"+
                "\n4)Просмотр текущих курсов \n5)Создание счета \n6)Внесение денег на счет. \n7)Удаление счета"+
                "\n8)Подсчет общей суммы на счетах в BYN \n9)Поиск операций текущего пользователя за временной диапозон(история)"+
                "\n10)Смена пароля \n11)Смена логина \n12)Выход из аккаунта");
    }
    public static void adminMenuMessage(){
        System.out.println("\n1)Аутенфикация и первоначальная регистрация. \n2)Просмотр всех клиентов \n3)Просмотр операий по клиенту." +
                " \n4)Удаление клиента \n5)Создание счета \n6)Просмотр счета с комиссиями \n7)Просмотр операций с неоплаченными комиссиями"+
                "\n8)Перевод комиссий на счет. \n9)Получить сумму комиссий не переведенных на счёт администратора "+
                "\n10)Регистрация пользователя \n11)Просмотр клиента по логину \n12)Просмотр все счетов " +
                "\n13)Просмотр всех операций \n14)Загрузка файла с курсами \n15)Смена пароля \n16)Смена логина \n17)Выход из аккаунта");
    }
    public static void autorizationMenuMessage(){
        System.out.println("\nНачальное меню! \n1)Авторизация. \n2)Регистрация. \n3)Выход.");
    }
    public static void exitMessage(){
        System.out.println("Всего доброго!");
    }
}
