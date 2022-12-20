package com.luo.java1;

import org.junit.Test;

import java.util.*;

/**
 * @author luozstart
 * @create 2022-12-17 22:17
 */
public class GenericTest {

    //在集合中使用泛型之前的情况：
    @Test
    public void test(){
        ArrayList<Object> list = new ArrayList<>();
        //需求：存放学生的成绩
        list.add(78);
        list.add(76);
        list.add(89);
        list.add(88);
        //问题一：类型不安全
        list.add("Tom");

        for(Object score :list){
            //问题二：强制转换时，可能出现ClassCastException
            int stuScore = (Integer) score;
            System.out.println(stuScore);

        }
    }

    @Test
    public void test2(){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(78);
        list.add(76);
        list.add(89);
        list.add(88);
        //编译时，就会进行类型检查，保证数据的安全
//        list.add("tom");
        for (Integer score :list){
            int stuScore = score;
            System.out.println(stuScore);
        }

        System.out.println("***********");

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            int sss = iterator.next();
            System.out.println(sss);
        }
    }

    //Map
    @Test
    public void test3(){
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("abc",123);

        Set<Map.Entry<String, Integer>> set = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = set.iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Integer> next = iterator.next();
            String key = next.getKey();
            Integer value = next.getValue();
            System.out.println(key+value);
        }
    }
}
