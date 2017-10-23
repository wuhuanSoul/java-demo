package com.systec.main.serializable;

import java.io.*;

/**
 * Created by wh on 10/11/2017.
 */
public class Person implements Serializable{
    private static final long serialVersionUID = 9146176880143026279L;
    private String username;
    private Salary salary;

    public Person(String username, Salary salary) {
        this.username = username;
        this.salary = salary;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Salary getSalary() {
        return salary;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
    }

    //序列化委托方法
    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject();
        oos.writeInt(salary.getBasePay());
    }
    //反序列化委托方法
    private void readObject(ObjectInputStream inputStream) throws IOException, ClassNotFoundException {
        inputStream.defaultReadObject();
        salary = new Salary(inputStream.read(), 0);
    }
}
