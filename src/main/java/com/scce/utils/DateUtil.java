package com.scce.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    //日期转换成字符串
    public static String dateToString(Date date, String patt){
        SimpleDateFormat sdf=new SimpleDateFormat(patt);
        String format=sdf.format(date);
        return  format;
    }
    //字符串转换成日期
    public static Date stringToDate(String str,String patt) throws ParseException {
        System.out.println("进入");
        SimpleDateFormat sdf=new SimpleDateFormat(patt);
        Date parse=sdf.parse(str);
        return parse;
    }
}
