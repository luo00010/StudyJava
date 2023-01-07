package com.luo.java3;

import com.luo.java2.Person;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 调用运行时类指定的结构：属性，方法，构造器
 *
 * @author luozstart
 * @create 2023-01-07 0:54
 */
public class ReflectionTest {

    @Test
    public void test1() throws NoSuchFieldException, InstantiationException, IllegalAccessException {
        Class<Person> c = Person.class;
        Person person = c.newInstance();

        //获取指定的属性(public)
        Field id = c.getField("id");

        //设置当前属性的值
        //set():参数1：指明设置哪个对象的属性     参数2：将此属性设置为多少
        id.set(person,100);

        //获取当前属性的值
        int pID = (int)id.get(person);
        System.out.println(pID);


        //获取权限小的属性
        Field age = c.getDeclaredField("age");

        //保证当前属性是可访问的
        age.setAccessible(true);

        age.set(person,123);
        System.out.println(age.get(person));
    }

    @Test
    public void test2() throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class<Person> c = Person.class;

        //造对象
        Person person = c.newInstance();

        //1.获取指定的某个方法
        //getDeclaredMethod()：参数1：指明获取的方法的名称 参数2：指明方法的形参列表
        Method show = c.getDeclaredMethod("show", String.class);

        //2.保证这个给方法是可访问的
        show.setAccessible(true);

        //3.调用invoke()：参数1：方法的调用者   参数2：给方法形参的实参

        Object xyz = show.invoke(person, "xyz");
        System.out.println(xyz);
    }


    @Test
    public void test3() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<Person> c = Person.class;
        //1.获取指定构造器
        Constructor<Person> declaredConstructor = c.getDeclaredConstructor(String.class,int.class);
        //2.保证可以访问
        declaredConstructor.setAccessible(true);
        //3.调用此构造器创建运行时类的对象
        Person xzy = declaredConstructor.newInstance("xzy",123);
        System.out.println(xzy);

    }
}
