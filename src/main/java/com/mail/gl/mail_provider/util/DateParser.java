package com.mail.gl.mail_provider.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateParser {
    public static Date parse(String date) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-DD");
        return (Date)formatter.parse(date);
    }
    public static Date formate(Date date) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-DD");
        return formatter.parse(date.toString());
    }
}
