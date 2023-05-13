package pvt.banking;


import pvt.banking.Users.Role;
import pvt.banking.Users.Users;
import pvt.banking.menu.ClientMenu;
import pvt.banking.serializableAndDeserializable.Deserializable;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static pvt.banking.menu.AutorizationMenu.menu1;
import static pvt.banking.serializableAndDeserializable.Deserializable.deserialize;
import static pvt.banking.serializableAndDeserializable.serializable.serializable;

public class Main {
    public static void main(String[] args) {
        List<Users> usersList = deserialize();
        menu1(usersList);
    }

public static void temp(List<Users> usersList){
        usersList.clear();
        Users users=new Users(0,"ant",123,"Anton",Role.Admin);
    Users users1=new Users(0,"ant",123,"Anton",Role.Admin);
        usersList.add(users);
        serializable(usersList);
}


    }
