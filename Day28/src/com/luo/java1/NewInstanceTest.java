package com.luo.java1;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 通过反射创建对应的运行时类的对象
 *
 * @author luozstart
 * @create 2023-01-06 21:06
 */
public class NewInstanceTest {
    @Test
    public void test1() throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class<Person> c = Person.class;
        Constructor<Person> constructor = c.getConstructor(String.class,int.class);
        Person person1 = constructor.newInstance("xyz",123);
        System.out.println(person1);
    }
}
