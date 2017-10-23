package com.systec.main;

import com.systec.main.serializable.Person;
import com.systec.main.serializable.Salary;
import com.systec.main.serializable.SerializationUtils;
import org.junit.Test;

import java.util.Date;

/**
 * Created by wh on 9/11/2017.
 */
public class mainTest {

    @Test
    public void dateTest() {
        System.out.println(new Date(System.currentTimeMillis()) + "  " +new Date(System.currentTimeMillis() + 60*1000));
        int count = 0;
        for(int i = 0; i < 10; i++){
            count = count++;
        }
        System.out.println(count);
    }

    @Test
    public void serialize(){
        Salary salary = new Salary(1000, 2000);
        Person person = new Person("张三", salary);
        SerializationUtils.writeObject(person);
    }

    @Test
    public void deserialize(){
        Person p = (Person) SerializationUtils.readObject();
        StringBuffer buffer = new StringBuffer();
        buffer.append("姓名: "+p.getUsername());
        buffer.append("\t基本工资: "+p.getSalary().getBasePay());
        buffer.append("\t绩效工资: "+p.getSalary().getBonus());
                System.out.println(buffer);
    }
}
