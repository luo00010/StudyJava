package com.luo.java3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * ArrayList的简单应用
 *
 * @author luozstart
 * @create 2022-11-20 14:58
 */
public class CollectionTest {
    /**
     * 创建 ArrayList 和使用add(),addAll(),size(),isEmpty()方法
     */
    @Test
    public void test1(){
        Collection coll = new ArrayList();

        //add(Object e)     //将元素e添加到coll中
        coll.add("avc");
        coll.add(123);
        coll.add(new Date());

        //size()        //获取添加的元素个数
        System.out.println(coll.size());

        //addAll(Collection coll):将coll集合中的元素添加到但钱集合中
         Collection coll1= new ArrayList();
         coll1.add("cdf");
         coll1.addAll(coll);
         System.out.println(coll1.size());

         //isEmpty():判断当前集合是否为空
        System.out.println(coll.isEmpty());
    }
}
