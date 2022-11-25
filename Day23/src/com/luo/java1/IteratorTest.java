package com.luo.java1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;

/**
 * Iterator接口遍历集合
 *
 *
 * @author luozstart
 * @create 2022-11-23 15:47
 */
public class IteratorTest {
    @Test
    public void test1(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person("Jerry",19));

        Iterator iterator = coll.iterator();
        //方式一:
//        for (int i = 0; i < coll.size(); i++) {
//            System.out.println(iterator.next());
//        }
        //方式二:推荐
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test2(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person("Jerry",19));

        Iterator i1 = coll.iterator();
        while (i1.hasNext()){
            Object obj = i1.next();
            if ("Tom".equals(obj)){
                i1.remove();
            }
        }

        System.out.println(coll);
    }
}
