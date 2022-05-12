package com.mail.elmaalmi.billal.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateParser {
    public static Date parse(String date) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-DD");
        return (Date)formatter.parse(date);
    }
    public static String formate(Date date) {
        try {
            String pattern = "MM-dd-yyyy";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String date_formating = simpleDateFormat.format(new Date());
            return date_formating;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
