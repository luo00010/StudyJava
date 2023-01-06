package com.luo.java2;

/**
 * @author luozstart
 * @create 2023-01-06 22:18
 */
@MyAnnotaion
public class Person extends Creatue<String> implements Comparable<String>,MyInterface{
    private String name;
    int age;
    public int id;

    public Person() {
    }

    @MyAnnotaion(value = "abc")
    private Person(String name) {
        this.name = name;
    }

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @MyAnnotaion
    private String show(String nation){
        System.out.println("我的国籍是："+nation);
        return nation;
    }

    public String display(String interests){
        return interests;
    }


    @Override
    public int compareTo(String o) {
        return 0;
    }

    @Override
    public void info() {
        System.out.println("我是一个人");
    }
}
