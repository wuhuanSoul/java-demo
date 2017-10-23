package com.systec.main.serializable;

import java.io.*;

/**
 * Created by wh on 10/11/2017.
 */
public class SerializationUtils {
    private static String FILE_NAME = "D:/obj.bin";

    //序列化
    public static void writeObject(Serializable s){
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME));
            oos.writeObject(s);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //反序列化
    public static Object readObject(){
        Object obj = null;
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME));
            obj = ois.readObject();
            ois.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return obj;
    }
}
