package com.luo.java1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author luozstart
 * @create 2022-11-27 15:44
 */
public class ListTest {
    @Test
    public void test1(){
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");
        list.add(new Person("Tom",19));
        list.add(456);

        System.out.println(list);

        //void add(int index,Object ele):在index位置插入ele
        list.add(1,"abc");
        System.out.println(list);

        //bollean addAll(int index,Collection eles):从index位置开始将else中的所有元素添加到原集合中
        List list1 = Arrays.asList(1,2,3);
        list.addAll(1,list1);
        System.out.println(list);

        //Object get(int index):找到index处的元素
        System.out.println(list.get(0));

        //int indexOf(Object obj):返回obj在集合中首次出现的位置,如果不存在，返回-1
        System.out.println(list.indexOf(456));

        //int lastIndexOf(Object obj):返回在当前集合中最后一次出现的位置
        System.out.println(list.lastIndexOf(456));

        //Object remove(int index):移除指定index索引的值;并返回删除的元素
        list.remove(0);

        //Object set(int index,Object ele):设置指定index位置的元素为ele
        list.set(1,"Cc");
        System.out.println(list);

        //List subList(int fromIndex,int toIndex):返回fromIndex到toIndex位置的左闭右开区间的集合
        List list2 = list.subList(2, 4);
        System.out.println(list2);
    }

    @Test
    public void test2(){
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");

        //方式一：iterator迭代器方式
        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        //方式二:增强for循环
        for (Object x:list){
            System.out.println(x);
        }

        //方式三：普通循环
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
    @Test
    public void test3(){
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        updateList(list);
        System.out.println(list);
    }
    public void updateList(List list){
//        list.remove(2);
        list.remove(new Integer(2));
    }

}
