package com.luo.exer;

import java.nio.channels.Pipe;
import java.time.Year;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;
import java.util.TreeSet;

/**
 * @author luozstart
 * @create 2022-12-15 15:09
 */
public class TreeSerSortTest {
    public static void main(String[] args) {
        Employee e1 = new Employee("Tome",19,new MyDate(2020,3,10));
        Employee e2 = new Employee("Jike",20,new MyDate(2110,20,30));
        Employee e3 = new Employee("Mike",20, new MyDate(2014,3,4));
        Employee e4 = new Employee("Tim",22,new MyDate(2020,4,10));
        Employee e5 = new Employee("Bob",11,new MyDate(2020,3,20));

        Comparator com = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Employee && o2 instanceof Employee){
                    MyDate m1 = ((Employee) o1).getBirthday();
                    MyDate m2 = ((Employee) o2).getBirthday();
                    if (m1.getYear()==m2.getYear()){
                        if (m1.getMonth()==m2.getMonth()){
                            return m1.getDay()-m2.getDay();
                        }else return m1.getMonth()-m2.getMonth();
                    }else return m1.getYear()-m2.getYear();
                }else throw new RuntimeException("类型有误");
            }
        };

        TreeSet t = new TreeSet(com);
        t.add(e1);
        t.add(e2);
        t.add(e3);
        t.add(e4);
        t.add(e5);

        Iterator iterator = t.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
class Employee implements Comparable{
    private String name;
    private int age;
    private MyDate birthday;

    public Employee(String name, int age, MyDate birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age && Objects.equals(name, employee.name) && Objects.equals(birthday, employee.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, birthday);
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Employee){
            Employee e = (Employee) o;
            return this.name.compareTo(e.name);
        } throw new RuntimeException("类型不一致");
    }
}
class MyDate{
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyDate myDate = (MyDate) o;
        return year == myDate.year && month == myDate.month && day == myDate.day;
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, month, day);
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }
}
