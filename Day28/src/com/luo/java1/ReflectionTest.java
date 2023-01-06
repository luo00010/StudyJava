package com.luo.java1;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.text.DateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Properties;
import java.util.zip.CRC32;

/**
 * @author luozstart
 * @create 2023-01-05 23:21
 */
public class ReflectionTest {

    //反射之前，
    @Test
    public void test1(){

        //1.创建Person类的对象
        Person p1 = new Person("Tom", 20);

        //2.通过对象，调用其内部的属性，方法
        p1.setAge(12);
        System.out.println(p1.getAge());

        p1.show();

        //在Person类外部，不可以通过Person类的对象调用其内部私有的结构
    }


    //反射之后
    @Test
    public void test2() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class c = Person.class;
        //1.通过反射，创建Person类的对象
        Constructor cons = c.getConstructor(String.class,int.class);

        Object obj = cons.newInstance("Tom",12);
        Person p1 = (Person) obj;

        //2.通过反射，调用对象指定的属性，方法
        Field age = c.getDeclaredField("age");


    }


    //获取Class的实例的方法
    @Test
    public void test3(){
        //方式一：调用运行时的属性：.class
        Class c1 = Person.class;
        System.out.println(c1);

        //方式二：通过运行时类的对象，调用getClass()
        Person p1 = new Person();
        Class c2 = p1.getClass();
        System.out.println(c2);

        //方式三：调用Class的静态方法：forName(String classPath)
        Class c3=null;
        try {
            c3 = Class.forName("com.luo.java1.Person");
            System.out.println(c3);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(c1==c2);
        System.out.println(c1==c3);
    }


    /*
    Properties:用来读取配置文件
     */
    @Test
    public void test4() throws Exception {

        Properties pros = new Properties();
        //此时的文件默认在当前的module下
        FileInputStream fis = new FileInputStream("jdbc.properties");
        pros.load(fis);

        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        System.out.println("user:"+user+" password:"+password);

    }
}
