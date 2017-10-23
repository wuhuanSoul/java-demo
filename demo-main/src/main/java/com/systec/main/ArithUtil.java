package com.systec.main;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by wh on 9/4/2017.
 */
public class ArithUtil {
    private static final int DIV_SCALE = 10;//除法精度（除不尽时保留10为小数）

    public static double add(double arg0, double arg1){
        BigDecimal bd0 = BigDecimal.valueOf(arg0);
        BigDecimal bd1 = BigDecimal.valueOf(arg1);
        return bd0.add(bd1).doubleValue();
    }

    public static double subtract(double arg0, double arg1){
        BigDecimal bd0 = BigDecimal.valueOf(arg0);
        BigDecimal bd1 = BigDecimal.valueOf(arg1);
        return bd0.subtract(bd1).doubleValue();
    }

    public static double multiply(double arg0, double arg1){
        BigDecimal bd0 = BigDecimal.valueOf(arg0);
        BigDecimal bd1 = BigDecimal.valueOf(arg1);
        return bd0.multiply(bd1).doubleValue();
    }

    public static double divide(double arg0, double arg1){
        BigDecimal bd0 = BigDecimal.valueOf(arg0);
        BigDecimal bd1 = BigDecimal.valueOf(arg1);
        return bd0.divide(bd1, DIV_SCALE, BigDecimal.ROUND_HALF_UP).doubleValue();
    }


    public static void main(String[] args) {
        double   f   =   111231.558;
        BigDecimal   b   =   new   BigDecimal(f);
        double   f1   =   b.setScale(2,   RoundingMode.HALF_DOWN).doubleValue();
        System.out.println(f1);
    }
}
