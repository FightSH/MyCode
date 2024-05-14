package org.example.ruangong;

import java.util.Calendar;
import java.util.Date;

public class GetLocalTime {
    public static void main(String[] args) {
        Date date = new Date();
        long time = date.getTime();
        Calendar calendar = Calendar.getInstance();
//        calendar.get();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        System.out.println(hour);
    }
}
