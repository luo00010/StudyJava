package com.luo.java3;

import com.luo.java2.Person;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * 获取运行时类的方法结构
 *
 * @author luozstart
 * @create 2023-01-06 22:49
 */
public class MethodTest {
    @Test
    public void test1(){
        Class<Person> c = Person.class;

        //getMethods():获取当前运行时类及其父类中的声明为public访问权限的方法
        Method[] methods = c.getMethods();
        for (Method m : methods){
            System.out.println(m);
        }

        System.out.println();

        //getDeclaredMethods():获取当前运行时类中声明的所有方法。（不包含父类中声明的方法）
        Method[] declaredMethods = c.getDeclaredMethods();
        for (Method m : declaredMethods){
            System.out.println(m);
        }
    }


    /*
    @Xxxx
    权限修饰符 返回值类型 方法名(形参) throws
     */
    @Test
    public void test2(){
        Class<Person> c = Person.class;
        Method[] declaredMethods = c.getDeclaredMethods();
        for (Method m : declaredMethods){
            //获取注解
            Annotation[] annotations = m.getAnnotations();
            for (Annotation a : annotations){
                System.out.println(a);
            }

            //权限修饰符
            int modifiers = m.getModifiers();
            System.out.print(Modifier.toString(modifiers)+" ");

            //返回值类型
            String name = m.getReturnType().getName();
            System.out.print(name+" ");

            //方法名
            System.out.print(m.getName());

            //形参列表
            System.out.print("(");
            Class<?>[] parameterTypes = m.getParameterTypes();
            if (!(parameterTypes == null || parameterTypes.length==0)){
                for (int i=0;i<parameterTypes.length;i++){
                    if (i==parameterTypes.length-1){
                        System.out.print(parameterTypes[i].getName());
                        break;
                    }
                    System.out.print(parameterTypes[i].getName()+",");
                }
            }
            System.out.print(")");

            //抛出异常
            Class<?>[] exceptionTypes = m.getExceptionTypes();
            if (!(exceptionTypes==null||exceptionTypes.length==0)){
                System.out.print("throws"+" ");
                for (int i=0;i<exceptionTypes.length;i++){
                    if (i==exceptionTypes.length-1){
                        System.out.print(exceptionTypes[i].getName());
                        break;
                    }
                    System.out.print(exceptionTypes[i].getName()+",");
                }
            }


            System.out.println();
        }
    }
}
