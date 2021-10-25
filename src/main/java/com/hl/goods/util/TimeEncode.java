package com.hl.goods.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeEncode {
    public static String getTime(){
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        return formatter.format(date);
    }
}
