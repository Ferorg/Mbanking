package pvt.banking.serializableAndDeserializable;

import pvt.banking.Users.Users;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
public class serializable {

    public static void serializable(List<Users> usersList){
        String file = "D:/javalessons/Mbanking/Ibanking/src/pvt/banking/data/UsersList.txt";
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file))){
            objectOutputStream.writeObject(usersList);
        } catch (Throwable e) {
            e.printStackTrace();
        }

    }

//

}
