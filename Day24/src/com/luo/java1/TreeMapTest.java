package com.luo.java1;

import org.junit.Test;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author luozstart
 * @create 2022-12-15 23:35
 */
public class TreeMapTest {
    @Test
    public void test1(){
        TreeMap map = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Employee&&o2 instanceof  Employee){
                    Employee e1 = (Employee) o1;
                    Employee e2 = (Employee) o2;
                    return e1.getAge()- e2.getAge();
                }throw new RuntimeException("类型异常");
            }
        });
        map.put(new Employee("Tom", 29),10);
        map.put(new Employee("Jery", 47),230);
        map.put(new Employee("Bob", 10),53);
        map.put(new Employee("Link", 23),51);
        map.put(new Employee("Serik", 23),21);
        map.put(new Employee("Deck", 29),99);

        for (Object o : map.entrySet()) {
            System.out.println(o);
        }

    }
}
