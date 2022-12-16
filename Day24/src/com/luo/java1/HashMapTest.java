package com.luo.java1;

import org.junit.Test;

import java.util.*;

/**
 *
 * Map常用方法
 *
 * @author luozstart
 * @create 2022-12-15 22:38
 */
public class HashMapTest {
    @Test
    public void test1(){
        Map map = new HashMap();
        //添加
        map.put("AA",123);
        map.put(45,123);
        map.put("BB",56);
        //修改
        map.put("AA",87);

        System.out.println(map);

        Map map1 = new HashMap();
        map1.put("CC",123);
        map1.put("DD",123);
        map1.putAll(map);
        System.out.println(map1);


        //remove(Object key)
        Object cc = map1.remove("CC");
        System.out.println(cc);
        System.out.println(map1);

        //clear()
        map.clear();
        System.out.println(map);
        System.out.println(map.size());
    }
    @Test
    public void test2(){
        Map map = new HashMap();
        map.put("AA",123);
        map.put(45,123);
        map.put("BB",56);

        //Object get(Object key)
        Object aa = map.get("AA");
        System.out.println(aa);

        //boolean containsKey(Object key)
        System.out.println(map.containsKey("BB"));
        //boolean containsValue(Object value)
        System.out.println(map.containsValue(123));

        //int size()
        System.out.println(map.size());

        //boolean isEmpty()
        System.out.println(map.isEmpty());

        //boolean equals(Object obj)
        Map map1 = new HashMap();
        map1.put("AA",123);
        map1.put(45,123);
        map1.put("BB",56);
        System.out.println(map1.equals(map));
    }

    @Test
    public void test3(){
        Map map = new HashMap();
        map.put("AA",1234);
        map.put(45,123);
        map.put("BB",56);

        //遍历所有的key集：keySet()
        Set set =map.keySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        //遍历所有value集：values()
        Collection values = map.values();
        Iterator iterator1 = values.iterator();
        while (iterator1.hasNext()){
            System.out.println(iterator1.next());
        }

        //遍历所有的key-value
        Set set1 = map.entrySet();
        for(Object obj : set1){
            System.out.println(obj);
        }
    }
}
