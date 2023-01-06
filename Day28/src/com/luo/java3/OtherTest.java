package com.luo.java3;

import com.luo.java2.Person;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/**
 * @author luozstart
 * @create 2023-01-07 0:25
 */
public class OtherTest {

    /*
    获取父类
     */
    @Test
    public void test1(){
        Class<Person> c = Person.class;
        //获取父类
        Class<? super Person> superclass = c.getSuperclass();
        System.out.println(superclass);

        //获取带泛型的父类
        Type genericSuperclass = c.getGenericSuperclass();
        System.out.println(genericSuperclass);
    }

    /*
    获取接口
     */
    @Test
    public void test2(){
        Class<Person> c = Person.class;
        Class<?>[] interfaces = c.getInterfaces();
        for (Class x : interfaces){
            System.out.println(x.getName());
        }
    }

    /*
    获取运行时类所在的包
     */
    @Test
    public void test3(){
        Class<Person> personClass = Person.class;
        Package aPackage = personClass.getPackage();
        System.out.println(aPackage);
    }

    /*
    获取运行时类声明的注解
     */
    @Test
    public void test4(){
        Class<Person> c = Person.class;
        Annotation[] annotations = c.getAnnotations();
        for (Annotation a : annotations){
            System.out.println(a);
        }
    }
}
