package pvt.banking.serializableAndDeserializable;

import pvt.banking.Users.Users;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class Deserializable {


    public static List<Users> deserialize() {
        String file = "D:/javalessons/Mbanking/Ibanking/src/pvt/banking/data/UsersList.txt";
        List<Users> usersList =new ArrayList<>();
        try (ObjectInputStream objectInputputStream = new ObjectInputStream(new FileInputStream(file))) {
            usersList = ( List<Users>) objectInputputStream.readObject();
            System.out.print(usersList.toString());
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return usersList;
    }
}
