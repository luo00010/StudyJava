package com.luo.java1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Collection接口中声明的方法测试
 *
 * 向Collection接口实现类的对象中添加数据obj时，要求obj所在类要重写equals()方法
 *
 * @author luozstart
 * @create 2022-11-23 14:02
 */
public class CollectionTest {
    @Test
    public void test1(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person("Tom",19));

        //1.contains(Object obj):判断当前集合中是否包含obj
        //调用equlas()
        boolean contains = coll.contains(123);
        System.out.println(contains);
        System.out.println(coll.contains(new String("Tom")));//判断值，而非判断地址,使用的是重写的equals方法
        System.out.println(coll.contains(new Person("Tom",19)));//用equls判断

        //2.containsAll(Collection coll1):判断形参coll1中所有元素是否都存在与当前集合中
        Collection coll1 = Arrays.asList(123,456);
        System.out.println(coll.containsAll(coll1));
    }


    @Test
    public void test2(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person("Jerry",19));

        //3.remove(Object obj)
        coll.remove(123);
        System.out.println(coll);

        coll.remove(new Person("Jerry",19));
        System.out.println(coll);

        //4.removeAll(Collection coll1) 从集合中删除coll1中所包含的元素
        Collection coll1 = Arrays.asList(123,456);
        coll.removeAll(coll1);
        System.out.println(coll);
    }

    @Test
    public void test3(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person("Jerry",19));

        //5.retainAll(Collection coll1);获取当前集合和coll1集合的交集，并返回给当前集合
        //也就是说 保留相同的，删除不同的
        Collection coll1 = Arrays.asList(123,456,789);
        coll.retainAll(coll1);
        System.out.println(coll);

        //6.equals(Object obj)  //判断当前集合和形参集合 中元素相同，并且要求有序
        Collection coll2 = new ArrayList();
        coll2.add(123);
        coll2.add(456);

        System.out.println(coll2.equals(coll));
    }

    @Test
    public void test4(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person("Jerry",19));

        //7.hashCode():返回当前对象的哈希值
        System.out.println(coll.hashCode());

        //8.toArray():集合转换成数组
        Object[] arr = coll.toArray();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        //拓展：数组-->集合:调用Arrays类的静态方法asList()
        List<Object> objects = Arrays.asList(arr);
        System.out.println(objects);

        //9.iterator():返回Iterator接口的实例，用于遍历集合元素。放在IteratorTest.java中
    }
}
