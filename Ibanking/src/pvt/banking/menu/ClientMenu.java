package pvt.banking.menu;

import pvt.banking.Users.Users;
import pvt.banking.massage.Massage;

import java.util.Scanner;

import static pvt.banking.serializableAndDeserializable.Deserializable.deserialize;

public class ClientMenu {
static boolean inMenu=true;
static Scanner in = new Scanner(System.in);


    public static void menuClient (){
        do{
            Massage.clientMenuMessage();
            int choise = in.nextInt();
        switch (choise) {
            case 1:

                break;
            case 2:
                System.out.println(2);
                break;
            case 3:
                System.out.println(3);
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
                inMenu=false;
                break;
            default:
                //выбрасывать свое исключение
                break;
        }
        }while(inMenu);

    }

}
