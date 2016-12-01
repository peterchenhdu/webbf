/*
 * File Name: TimeUtil.java
 * Copyright: Copyright 2016-2016 hdu All Rights Reserved.

 * Description:
 * Author: Pi Chen
 * Create Date: 2016年8月26日

 * Modifier: Pi Chen
 * Modify Date: 2016年8月26日
 * Bugzilla Id:
 * Modify Content:
 */
package cn.edu.hdu.webbf.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 时间工具类
 *
 * @author Pi Chen
 * @version webbf V1.0.0, 2016年11月02日
 * @see
 * @since webbf V1.0.0
 */

public class TimeUtil
{

    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";


    /**
     * 获取当前时间
     *
     * @return
     */
    public static String getCurTime()
    {
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_TIME_FORMAT);
        return formatter.format(new Date());
    }

    /**
     * 获取年初时间
     *
     * @return
     */
    public static String getYearStartTime()
    {
        return new GregorianCalendar().get(Calendar.YEAR) + "-01-01 00:00:00";
    }

    /**
     *
     * 根据指定时间差获取时间
     *
     * @param comparedDate
     * @param y
     * @param m
     * @param d
     * @param h
     * @return
     */
    public static String getDate(Date comparedDate, int y, int m, int d, int h)
    {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(comparedDate);
        calendar.add(Calendar.YEAR, y);
        calendar.add(Calendar.MONTH, m);
        calendar.add(Calendar.DATE, d);
        calendar.add(Calendar.HOUR, h);
        Date date = calendar.getTime();
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_TIME_FORMAT);
        return formatter.format(date);
    }

}
