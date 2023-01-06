package com.luo.java3;

import com.luo.java2.Person;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * 获取当前运行时类的属性结构
 *
 * @author luozstart
 * @create 2023-01-06 22:30
 */
public class FieldTest {

    @Test
    public void test1(){
        Class<Person> c1 = Person.class;

        //获取属性
        //getFields():获取当前运行时类及其父类中的声明为public访问权限的属性
        Field[] fields = c1.getFields();
        for (Field f : fields){
            System.out.println(f);
        }

        System.out.println();

        //getDeclaredFields():获取当前运行时类中声明的所有属性。（不包含父类中声明的属性）
        Field[] declaredFields = c1.getDeclaredFields();
        for (Field f : declaredFields){
            System.out.println(f);
        }
    }


    //权限修饰符 数据类型 变量名
    @Test
    public void test2(){
        Class<Person> c1 = Person.class;
        Field[] declaredFields = c1.getDeclaredFields();
        for (Field f : declaredFields){
            //1.权限修饰符
            int modifiers = f.getModifiers();
            System.out.print(Modifier.toString(modifiers)+" ");

            //2.数据类型
            Class<?> type = f.getType();
            System.out.print(type+" ");


            //3.变量名
            String name = f.getName();
            System.out.println(name);
        }
    }
}
