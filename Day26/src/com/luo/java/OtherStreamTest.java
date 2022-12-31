package com.luo.java;

import org.junit.Test;

import java.io.*;
import java.util.Locale;

/**
 * @author luozstart
 * @create 2022-12-24 13:27
 */
public class OtherStreamTest {
    /*
    1.3练习
    从键盘输入字符串，要求将读取到的整行字符串转成大写输出。然后继续进行操作。
直至当输入“e”或者“exit”时，退出程序
     */
    @Test
    public void test1(){
        BufferedReader br = null;
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            br = new BufferedReader(isr);
            while (true) {
                String str = br.readLine();
                if ("e".equalsIgnoreCase(str)||str=="exit"||"exit".equalsIgnoreCase(str)) break;
                String str1 = str.toUpperCase(Locale.ROOT);
                System.out.println(str1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br!=null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
