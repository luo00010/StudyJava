package com.luo.java1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

/**
 * @author luozstart
 * @create 2022-12-15 23:47
 */
public class PropertiesTest {
    // Properties:常用来处理配置文件。key和value都是String类型
    public static void main(String[] args) throws Exception {
        Properties pros = new Properties();

        FileInputStream fileInputStream = new FileInputStream("JDBCTEST.properties");
        pros.load(fileInputStream);//加载流文件

        String name = pros.getProperty("name");
        String password = pros.getProperty("password");

        System.out.println("name = "+name+",password = "+password);
    }
}
