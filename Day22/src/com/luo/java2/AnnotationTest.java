package com.luo.java2;

import java.beans.PropertyVetoException;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;

/**
 * 注解的使用
 * 1.理解Annotation：
 * ①jdk 5.0 新增功能
 * ②代码里的特殊标记
 * ③....
 *
 * 2.Annocation的使用示例
 * 示例一：详细看Typora
 * 失利二：详细看Typora
 *
 * 3.如何自定义注解:参照@SuppressWarnings
 *
 *
 * 4.元注解（修饰注解的注解）
 *  1.Retention：指定所修饰的Annotation的声明周期：SOURCE\CLASS(默认行为) \RUNTIME  只有声明为RUNTIME生命周期的注解，才能通过反射获取。
 *  2.Target：用于指定被修饰的Annotation能用于修饰哪些程序元素
 *  3.Documented：表示所修饰的注解在被javadoc解析式，保留下来。
 *  4.Inherited：被它修饰的 注解 将具有继承性
 *
 *
 * 5.可重复性注解：
 * 类型注解：
 *
 * @author luozstart
 * @create 2022-11-19 22:55
 */
public class AnnotationTest {

}


class Preson{
    private  String name;
    private int age;

    public Preson() {
    }

    public Preson(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public void walk(){
        System.out.println("人走路");
    }
    public void eat(){
        System.out.println("人吃饭");
    }
}

interface Info{
    void show();
}

@MyAnnotation("hello")
class Studeny extends Preson implements Info{

    @Override
    public void show() {

    }

}

//自定义
@Repeatable(MyAnnotations.class)
@interface MyAnnotation{
    String value() default "HELLO"; //默认值
}

@interface MyAnnotations{
    MyAnnotation[] value();
}