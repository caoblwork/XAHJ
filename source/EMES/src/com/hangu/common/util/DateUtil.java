package com.hangu.common.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Date Utility Class This is used to convert Strings to Dates and Timestamps
 * 
 * lixf
 */
public class DateUtil {

    // ~ Static fields/initializers
    // =============================================
    private static final Logger logger = LoggerFactory.getLogger(DateUtil.class);

    private static String defaultDatePattern = "yyyy-MM-dd";

    private static String timePattern = "HH:mm:ss";

    /**
     * 
     */
    public static String[] weekDayName = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };

    /**
     * This method attempts to convert an Oracle-formatted date in the form
     * dd-MMM-yyyy to mm/dd/yyyy.
     * 
     * @param aDate date from database as a string
     * @return formatted string for the ui
     */
    public static final String getDate(Date aDate) {
        SimpleDateFormat df = null;
        String returnValue = "";

        if (aDate != null) {
            df = new SimpleDateFormat(getDatePattern());
            returnValue = df.format(aDate);
        }

        return returnValue;
    }

    public static String getDatePattern() {
        return defaultDatePattern;
    }

    public static String getDateTimePattern() {
        return getDatePattern() + " " + timePattern;
    }

    /**
     * This method generates a string representation of a date/time in the
     * format you specify on input
     * 
     * @param aMask the date pattern the string is in
     * @param strDate a string representation of a date
     * @return a converted Date object
     * @see java.text.SimpleDateFormat
     * @throws ParseException
     */
    public static final Date convertStringToDate(String aMask, String strDate) {
        SimpleDateFormat df = null;
        Date date = null;
        df = new SimpleDateFormat(aMask);
        logger.debug("converting '" + strDate + "' to date with mask '" + aMask + "'");
        try {
            date = df.parse(strDate);
        } catch (ParseException pe) {
            logger.error("ParseException: " + pe);
        }

        return date;
    }

    /**
     * This method returns the current date time in the format: MM/dd/yyyy HH:MM
     * a
     * 
     * @param theTime the current time
     * @return the current date/time
     */
    public static String getTimeNow(Date theTime) {
        return getDateTime(timePattern, theTime);
    }

    /**
     * This method returns the current date in the format: yyyy-MM-dd
     * 
     * @return the current date
     * @throws ParseException
     */
    public static Calendar getToday() {
        Date today = getDateNow();
        SimpleDateFormat df = new SimpleDateFormat(getDatePattern());

        // This seems like quite a hack (date -> string -> date),
        // but it works ;-)
        String todayAsString = df.format(today);
        Calendar cal = new GregorianCalendar();
        cal.setTime(convertStringToDate(todayAsString));

        return cal;
    }

    /**
     * This method generates a string representation of a date's date/time in
     * the format you specify on input
     * 
     * @param aMask the date pattern the string is in
     * @param aDate a date object
     * @return a formatted string representation of the date
     * 
     * @see java.text.SimpleDateFormat
     */
    public static final String getDateTime(String aMask, Date aDate) {
        SimpleDateFormat df = null;
        String returnValue = "";

        if (aDate == null) {
            logger.error("aDate is null!");
        } else {
            df = new SimpleDateFormat(aMask);
            returnValue = df.format(aDate);
        }

        return returnValue;
    }

    public static final String convertDate2String(Date date, String format) {
        SimpleDateFormat df = null;
        String returnValue = "";
        if (date == null) {
            logger.error("aDate is null!");
        } else {
            df = new SimpleDateFormat(format);
            returnValue = df.format(date);
        }

        return returnValue;
    }

    /**
     * This method generates a string representation of a date based on the
     * System Property 'dateFormat' in the format you specify on input
     * 
     * @param aDate A date to convert
     * @return a string representation of the date
     */
    public static final String convertDateToString(Date aDate) {
        return getDateTime(getDatePattern(), aDate);
    }

    public static final String getCurrentYear() {
        return getDateTime(getDatePattern(), getDateNow()).substring(0, 4);
    }

    public static final String getCurrentMonth() {
        return getDateTime(getDatePattern(), getDateNow()).substring(5, 7);
    }

    public static int getCurrentWeekOfMonth() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.WEEK_OF_MONTH);
    }

    /**
     * This method converts a String to a date using the datePattern
     * 
     * @param strDate the date to convert (in format MM/dd/yyyy)
     * @return a date object
     * 
     * @throws ParseException
     */
    public static Date convertStringToDate(String strDate) {
        Date aDate = null;
        logger.debug("converting date with pattern: " + getDatePattern());
        aDate = convertStringToDate(getDatePattern(), strDate);
        return aDate;
    }

    public static Date getBeginOfMonth(Date date, int months) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        if (months != 0) {
            calendar.add(GregorianCalendar.MONTH, months);
        }
        calendar.set(GregorianCalendar.DAY_OF_MONTH, calendar.getActualMinimum(GregorianCalendar.DAY_OF_MONTH));
        return (Date) calendar.getTime().clone();
    }

    public static Date getEndOfMonth(Date date, int months) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        if (months != 0) {
            calendar.add(GregorianCalendar.MONTH, months);
        }
        calendar.set(GregorianCalendar.DAY_OF_MONTH, calendar.getActualMaximum(GregorianCalendar.DAY_OF_MONTH));
        return (Date) calendar.getTime().clone();
    }

    public static Date getBeginOfYear(Date date) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.set(GregorianCalendar.MONTH, calendar.getActualMinimum(GregorianCalendar.MONTH));
        calendar.set(GregorianCalendar.DAY_OF_MONTH, calendar.getActualMinimum(GregorianCalendar.DAY_OF_MONTH));
        calendar.set(GregorianCalendar.HOUR_OF_DAY, calendar.getActualMinimum(GregorianCalendar.HOUR_OF_DAY));
        calendar.set(GregorianCalendar.MINUTE, calendar.getActualMinimum(GregorianCalendar.MINUTE));
        calendar.set(GregorianCalendar.SECOND, calendar.getActualMinimum(GregorianCalendar.SECOND));
        calendar.set(GregorianCalendar.MILLISECOND, calendar.getActualMinimum(GregorianCalendar.MILLISECOND));
        return (Date) calendar.getTime().clone();
    }

    public static Date getEndOfYear(Date date) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.set(GregorianCalendar.MONTH, calendar.getActualMaximum(GregorianCalendar.MONTH));
        calendar.set(GregorianCalendar.DAY_OF_MONTH, calendar.getActualMaximum(GregorianCalendar.DAY_OF_MONTH));
        calendar.set(GregorianCalendar.HOUR_OF_DAY, calendar.getActualMaximum(GregorianCalendar.HOUR_OF_DAY));
        calendar.set(GregorianCalendar.MINUTE, calendar.getActualMaximum(GregorianCalendar.MINUTE));
        calendar.set(GregorianCalendar.SECOND, calendar.getActualMaximum(GregorianCalendar.SECOND));
        calendar.set(GregorianCalendar.MILLISECOND, calendar.getActualMaximum(GregorianCalendar.MILLISECOND));
        return (Date) calendar.getTime().clone();
    }

    public static int getYearOfDate(Date date) {
        Calendar calendar = new GregorianCalendar();
        return calendar.get(Calendar.YEAR);
    }

    public static Date getEndOfYear(int year) {
        Calendar calendar = new GregorianCalendar();
        calendar.set(GregorianCalendar.YEAR, year);
        calendar.set(GregorianCalendar.MONTH, calendar.getActualMaximum(GregorianCalendar.MONTH));
        calendar.set(GregorianCalendar.DAY_OF_MONTH, calendar.getActualMaximum(GregorianCalendar.DAY_OF_MONTH));
        calendar.set(GregorianCalendar.HOUR_OF_DAY, calendar.getActualMaximum(GregorianCalendar.HOUR_OF_DAY));
        calendar.set(GregorianCalendar.MINUTE, calendar.getActualMaximum(GregorianCalendar.MINUTE));
        calendar.set(GregorianCalendar.SECOND, calendar.getActualMaximum(GregorianCalendar.SECOND));
        calendar.set(GregorianCalendar.MILLISECOND, calendar.getActualMaximum(GregorianCalendar.MILLISECOND));
        return (Date) calendar.getTime().clone();
    }

    public static int monthsBetween(Date startDate, Date endDate) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(startDate);
        int startMonth = calendar.get(GregorianCalendar.MONTH);
        int startYear = calendar.get(GregorianCalendar.YEAR);
        calendar.setTime(endDate);
        int endMonth = calendar.get(GregorianCalendar.MONTH);
        int endYear = calendar.get(GregorianCalendar.YEAR);
        return (endYear - startYear) * 12 + (endMonth - startMonth);
    }

    public static int daysBetween(Date startDate, Date endDate) {
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(startDate);
        c2.setTime(endDate);
        return daysBetween(c1, c2);
    }

    public static int daysBetween(Calendar early, Calendar late) {
        return (int) (toJulian(late) - toJulian(early));
    }

    public static final float toJulian(Calendar c) {
        int Y = c.get(Calendar.YEAR);
        int M = c.get(Calendar.MONTH);
        int D = c.get(Calendar.DATE);
        int A = Y / 100;
        int B = A / 4;
        int C = 2 - A + B;
        float E = (int) (365.25f * (Y + 4716));
        float F = (int) (30.6001f * (M + 1));
        float JD = (C + D + E + F) - 1524.5f;
        return JD;
    }

    /**
     * 获取当前时间
     * 
     * @return 当前日期时间
     */
    public static Date getDateNow() {
        return Calendar.getInstance().getTime();
    }

    /**
     * 获取当前时间
     * 
     * @return 当前日期时间
     */
    public static Timestamp getTimestampNow() {
        return new Timestamp(System.currentTimeMillis());
    }

    /**
     * 获取指定日期对应月份的第一天
     * 
     * @param date 指定日期
     * @return 月份的第一天
     */
    public static Date getFirstDayOfMonth(Date date) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return calendar.getTime();
    }

    /**
     * 获取指定日期对应月份的最后一天
     * 
     * @param date 指定日期
     * @return 月份的最后一天
     */
    public static Date getLastDayOfMonth(Date date) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, 1);
        calendar.set(Calendar.DATE, 1);
        calendar.add(Calendar.DATE, -1);
        return calendar.getTime();
    }

    public static Date getNextDay(Date date) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(GregorianCalendar.DAY_OF_MONTH, 1);
        return (Date) calendar.getTime().clone();
    }

    public static Date getNextNDay(Date date, int n) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(GregorianCalendar.DAY_OF_MONTH, n);
        return (Date) calendar.getTime().clone();
    }

    /**
     * 获取某天的结束时间 yyyy-MM-dd 00:00:00
     * 
     * @param day
     * @return
     */
    public static String getDayBegin(int day) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(DateUtil.getDatePattern());
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_WEEK, day + 1);

        String thisDay = dateFormat.format(calendar.getTime()) + " 00:00:00";
        return thisDay;
    }

    /**
     * 获取某天的结束时间 yyyy-MM-dd 23:59:59
     * 
     * @param day
     * @return
     */
    public static String getDayOver(int day) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(DateUtil.getDatePattern());
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_WEEK, day + 1);

        String thisDay = dateFormat.format(calendar.getTime()) + " 23:59:59";
        return thisDay;
    }

    public static Date extendConvertStringToDate(String dateStr) {
        String[] datePatterns = { "yyyyMMdd", "yyyy/MM/dd", "yyMMdd", "yy/MM/dd", "yyMd", "yy/M/d", "yyyy/M/d", "yyyyMd" };
        Date returnDate = null;
        String source = StringUtils.replace(dateStr, ".", "/");
        // 年月日汉字
        source = StringUtils.replace(source, "年", "/");
        source = StringUtils.replace(source, "月", "/");
        source = StringUtils.replace(source, "日", "");
        // 反斜线
        source = StringUtils.replace(source, "\\", "/");
        // 句号
        source = StringUtils.replace(source, "。", "/");
        source = StringUtils.replace(source, ".", "/");
        // 逗号
        source = StringUtils.replace(source, "，", "/");
        source = StringUtils.replace(source, ",", "/");
        // 顿号
        source = StringUtils.replace(source, "、", "/");
        // 下划线
        source = StringUtils.replace(source, "_", "/");
        // 中划线
        source = StringUtils.replace(source, "—", "/");
        source = StringUtils.replace(source, "-", "/");
        // 空格
        source = StringUtils.replace(source, "　", "/");
        source = StringUtils.replace(source, " ", "/");
        // 冒号
        source = StringUtils.replace(source, "：", "/");
        source = StringUtils.replace(source, ":", "/");
        // 问号
        source = StringUtils.replace(source, "?", "/");
        source = StringUtils.replace(source, "？", "/");
        // 分号
        source = StringUtils.replace(source, ";", "/");
        source = StringUtils.replace(source, "；", "/");

        source = StringUtils.replace(source, "＼", "/");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        for (String pattern : datePatterns) {
            simpleDateFormat.applyPattern(pattern);
            try {
                returnDate = simpleDateFormat.parse(source);
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(returnDate);
                int year = calendar.get(Calendar.YEAR);
                if (year < 100) {
                    calendar.set(Calendar.YEAR, year + 2000);
                }
                returnDate = calendar.getTime();
            } catch (ParseException e) {
                continue;
            }
            break;
        }
        return returnDate;
    }
}
