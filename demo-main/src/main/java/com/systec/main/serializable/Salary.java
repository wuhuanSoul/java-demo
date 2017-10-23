package com.systec.main.serializable;

import java.io.Serializable;

/**
 * Created by wh on 10/11/2017.
 */
public class Salary implements Serializable{
    private static final long serialVersionUID = 2706085398747859680L;
    private int basePay;
    private int bonus;

    public Salary(int basePay, int bonus) {
        this.basePay = basePay;
        this.bonus = bonus;
    }

    public int getBasePay() {
        return basePay;
    }

    public void setBasePay(int basePay) {
        this.basePay = basePay;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }
}
