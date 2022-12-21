package com.luo.java2;

import org.junit.Test;

import java.util.Iterator;
import java.util.List;

/**
 * @author luozstart
 * @create 2022-12-20 23:25
 */
public class GenericTest {

    @Test
    public void test1(){
        Object obj = null;
        String str = null;
        obj = str;

        Object[] arr1 = null;
        String[] arr2 = null;
        arr1 = arr2;

        List<Object> list1 = null;
        List<String> list2 = null;
        //此时的list1和list2的类型不具有子父类关系
        //list1 = list2;
        /*
        反证法：
        假设list1 = list2;
            list1.add(123);导致混入非String数据。很显然不合理

         */
    }
    /*
    2.通配符的使用
        通配符：？
     */
    @Test
    public void test2(){
         List<Object> list1 = null;
         List<String> list2 = null;

         List<?> list  = null;

         list = list1;
         list = list2;
    }
    public void print(List<?> list){
        Iterator<?> iterator = list.iterator();
        while (iterator.hasNext()){
            Object obj = iterator.next();
            System.out.println(obj);
        }
    }
}
