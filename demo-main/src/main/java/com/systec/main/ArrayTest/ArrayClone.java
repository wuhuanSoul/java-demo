package com.systec.main.ArrayTest;

import com.systec.main.User;
import org.apache.commons.beanutils.BeanUtils;

/**
 * Created by wh on 9/7/2017.
 */
public class ArrayClone {

    public static void main(String[] args) throws Exception {
        User u1 = new User();
        u1.setId(1);
        u1.setName("aa");
        u1.setAge(1);
        u1.setAddress("1");

        System.out.println(u1.toString());
        User u2 = new User();
//        u2 = (User)BeanUtils.cloneBean(u1);   //浅复制，复制的对象引用
        u2 = u1;
        System.out.println(u2.getName() + u2.getAddress());
        u2.setAge(1111);
        System.out.println("=========");
        System.out.println(u1.toString());
        System.out.println(u2.toString());
    }
}
