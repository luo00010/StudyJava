package com.luo.java;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * SimpleDateFormat
 * Calendar
 * 
 * @author luozstart
 * @create 2022-11-13 22:24
 */
public class DateTimeTest {
    /*
    SimpleDateFormat的使用：SimpleDateFormat对日期Date类的格式化和解析

    1.两个操作：
    1.1 格式化：日期--->字符串
    1.2 解析：格式化的逆过程，字符串--->日期
     */
    @Test
    public void testSimpleDateFormat() throws ParseException {
        //实例化:使用默认的构造器
        SimpleDateFormat sdf = new SimpleDateFormat();

        //格式化:日期--->字符串
        Date date = new Date();
        System.out.println(date);

        String format = sdf.format(date);
        System.out.println(format);

        //解析：格式化的逆过程，字符串--->日期  只能指定格式
        String str = "22-11-13 上午10:22";
        Date date1=sdf.parse(str);
        System.out.println(date1);

        //SimpleDateFormat sdf = new SimpleDateForamt("yyyy.MMMM.dd GGG hh:mm:aa");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        //格式化
        String format1 = sdf1.format(date);
        System.out.println(format1);

        //解析
        Date date2 = sdf1.parse("2022-11-13 12:20:22");
        System.out.println(date2);
    }


    /*
    练习一：字符串"2020-09-08"转换为java.sql.Date

     */
    @Test
    public void testExer() throws ParseException {
        String birth = "2020-09-08";
        SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
        Date date = sdf.parse(birth);
        //System.out.println(date);
        java.sql.Date birthDate = new java.sql.Date(date.getTime());
        System.out.println(birthDate);

    }


    //Calendar日历类（抽象类）的使用
    @Test
    public void testCalendar(){
        //1.实例化
        Calendar calendar = Calendar.getInstance();


        //2.常用方法
        //get();
        int days = calendar.get(Calendar.DAY_OF_MONTH);//获取今天是几号
        System.out.println(days);
        int yearDays = calendar.get(Calendar.DAY_OF_YEAR);//今天是今年的第几天
        System.out.println(yearDays);

        System.out.println("***");

        //set();
        calendar.set(Calendar.DAY_OF_MONTH,5);  //修改当月的第几天
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));

        System.out.println("***");

        //add()
        calendar.add(Calendar.DAY_OF_MONTH,5);//相加操作，如果要相减，输入负数即可
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));

        //getTime():日例类--->Date
        Date date = calendar.getTime();
        System.out.println(date);

        //setTime():Date--->日历类
        Date date1 = new Date();
        calendar.setTime(date1);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);
    }

}
