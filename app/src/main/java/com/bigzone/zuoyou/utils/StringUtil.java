package com.bigzone.zuoyou.utils;

import java.text.DecimalFormat;

/**
 * Created by seriex.x on 17/1/4.
 */

public class StringUtil {
    public static String changes(Double a){
        DecimalFormat fnum = new DecimalFormat("###########0.00");
        String dd=fnum.format(a);
        return dd;
    }
    public static String changes(float a){
        DecimalFormat fnum = new DecimalFormat("###########0.00");
        String dd=fnum.format(a);
        return dd;
    }
    public static String changes(int a){
        DecimalFormat fnum = new DecimalFormat("###########0.00");
        String dd=fnum.format(a);
        return dd;
    }
    public static String change(Double a){
        DecimalFormat fnum = new DecimalFormat("###,###,###,##0.00");
        String dd=fnum.format(a);
        return dd;
    }
    public static String change(float a){
        DecimalFormat fnum = new DecimalFormat("###,###,###,##0.00");
        String dd=fnum.format(a);
        return dd;
    }
    public static String change(int a){
        DecimalFormat fnum = new DecimalFormat("###,###,###,##0.00");
        String dd=fnum.format(a);
        return dd;
    }
}
