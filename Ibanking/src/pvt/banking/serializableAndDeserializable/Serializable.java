package pvt.banking.serializableAndDeserializable;

import pvt.banking.Users.Users;


import java.util.List;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
public class Serializable {

    public static void serializable(List<Users> usersList){
        String file = "D:/javalessons/Mbanking/Ibanking/src/pvt/banking/data/UsersList.txt";
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file))){
            objectOutputStream.writeObject(usersList);
            objectOutputStream.close();
        } catch (Throwable e) {
            e.printStackTrace();
        }


    }

}
