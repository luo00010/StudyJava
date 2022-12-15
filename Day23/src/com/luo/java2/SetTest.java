package com.luo.java2;

/**
 * @author luozstart
 * @create 2022-12-11 21:28
 */

import com.luo.java1.Person;
import org.junit.Test;

import java.util.*;

/**
 * Collection接口：单列集合，用来存储一个一个的对象
 *     -- Set接口：存储无序的，不可重复的数据 -->高中讲的集合
 *          --HashSet:作为Set接口的主要实现类；线程不安全的；可以存储null值
 *          --LinkedHashSet：
 *          --TreeSet
 * @author luozstart
 * @create 2022-12-11 21:02
 */
public class SetTest {
    @Test
    public void test1(){
        Set set = new HashSet();
        set.add(456);
        set.add(123);
        set.add(123);
        set.add("AA");
        set.add("CC");
        set.add(new Person("Tome",12));
        set.add(new Person("Tome",12));
        set.add(129);

        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    @Test
    public void test2(){
        TreeSet treeSet = new TreeSet();
        treeSet.add(123);
        treeSet.add(-30);
        treeSet.add(111);
        treeSet.add(-2);
        treeSet.add(99);
        treeSet.add(234);

        Iterator iterator = treeSet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    @Test
    public void test3(){
        Comparator com = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Person && o2 instanceof Person) {
                    Person p1 = (Person) o1;
                    Person p2 = (Person) o2;
                    if (p1.getName() != p2.getName()) {
                        return p1.getName().compareTo(p2.getName());
                    } else return p1.getAge() - p2.getAge();
                } else throw new RuntimeException("类型不一致");
            }
        };

        TreeSet set = new TreeSet(com);
        set.add(new Person("Tome",12));
        set.add(new Person("Xxx",19));
        set.add(new Person("Mike",20));
        set.add(new Person("Tome",10));
        set.add(new Person("Jemo",30));

        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
