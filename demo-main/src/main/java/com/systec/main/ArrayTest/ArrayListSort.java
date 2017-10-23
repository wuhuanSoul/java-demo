package com.systec.main.ArrayTest;

import com.systec.main.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by wh on 8/15/2017.
 */
public class ArrayListSort {
    public static void main(String[] args) {
        User u1 = new User();
        u1.setId(1);
        u1.setName("aa");
        u1.setAge(1);
        u1.setAddress("1");
        User u2 = new User();
        u2.setId(2);
        u2.setName("bb");
        u2.setAge(2);
        u2.setAddress("2");
        User u3 = new User();
        u3.setId(13);
        u3.setName("ee");
        u3.setAge(22);
        u3.setAddress("22");
        ArrayList<User> list = new ArrayList<User>();
        list.add(u1);
        list.add(u3);
        list.add(u2);
        list.add(u3);
        for (int i = 0; list.size() > i; i++) {
            User user = list.get(i);
            System.out.println(user.toString());
        }
        Collections.sort(list, new Comparator() {
            public int compare(Object o1, Object o2) {
                User room1 = (User) o1;
                User room2 = (User) o2;
                return room1.getName().compareTo(room2.getName());
            }
        });
        System.out.println("========");
        for (int i=0; list.size()>i; i++){
            User user = list.get(i);
            System.out.println(user.toString());
        }

    }
}
