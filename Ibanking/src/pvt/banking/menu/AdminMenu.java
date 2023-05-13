package pvt.banking.menu;

import pvt.banking.massage.Massage;

import java.util.Scanner;



public class AdminMenu {
    static boolean inMenu=true;
    static Scanner in = new Scanner(System.in);
    public static void menuAdmin (){
        do{
            Massage.adminMenuMessage();
            int choise = in.nextInt();
            switch (choise) {
                case 1:
                    System.out.println(11);
                    break;
                case 2:
                    System.out.println(22);
                    break;
                case 3:
                    System.out.println(33);
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    break;
                case 11:
                    break;
                case 12:
                    break;
                case 13:
                    break;
                case 14:
                    break;
                case 15:
                    break;
                case 16:
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
}
