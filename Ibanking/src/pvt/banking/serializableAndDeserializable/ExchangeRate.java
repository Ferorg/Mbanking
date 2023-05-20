package pvt.banking.serializableAndDeserializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ExchangeRate {
    public static void serializableValuet(Map<String, Double> currency){
        String file = "D:/javalessons/Mbanking/Ibanking/src/pvt/banking/data/KursList.txt";
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file))){
            objectOutputStream.writeObject(currency);
            objectOutputStream.close();
        } catch (Throwable e) {
            e.printStackTrace();
        }

    }
    public static Set<Map.Entry<String,Double>> deserializeCurrency() {
        String file = "D:/javalessons/Mbanking/Ibanking/src/pvt/banking/data/KursList.txt";
        Map<String, Double> currency = new HashMap<>();
        try (ObjectInputStream objectInputputStream = new ObjectInputStream(new FileInputStream(file))) {
            currency = (Map<String, Double>) objectInputputStream.readObject();
            objectInputputStream.close();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        Set<Map.Entry<String,Double>>entrySet=currency.entrySet();
        return entrySet;
    }
    public static void outputInformationAboutKurs(){
        Set<Map.Entry<String, Double>> entrySet = ExchangeRate.deserializeCurrency();
        for (Map.Entry<String, Double> a:entrySet) {
            System.out.print(a+"; ");

        }
    }
}
