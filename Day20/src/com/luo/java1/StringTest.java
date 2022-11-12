package com.luo.java1;

import org.junit.Test;

import java.util.Locale;

/**
 * @author luozstart
 * @create 2022-11-09 16:59
 */
public class StringTest {
    @Test
    public void test1(){
        String s1 = "AAvdYTFDCA";
        System.out.println(s1.isEmpty());   //判断是否为空
        String s2 = s1.toLowerCase();   //将字符串转换成小写
        String s3 = s1.toUpperCase();   //将字符串转成大写
        String s4 = " he llo wo rld   ";
        String s5 = s4.trim();          //去除收尾空格
        char[] j = s1.toCharArray();

        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s5);
    }

    @Test
    public  void test2(){
        String s1 = "HelloWorld";
        String s2 = "HelloWorld";
        System.out.println(s1.equals(s2));      //比较字符串内容是否相等
        System.out.println(s1.equalsIgnoreCase(s2));    //忽略大小写的equals方法

        String s3 = s1.concat(s2);          //连接两个字符，等价"+"
        System.out.println(s3);
        System.out.println(s1.compareTo(s2));   //比较大小

        System.out.println();
    }
}
