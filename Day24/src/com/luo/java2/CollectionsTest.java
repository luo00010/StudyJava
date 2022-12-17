package com.luo.java2;

import org.junit.Test;

import java.util.*;

/**
 *  Collections:操作Collection，Map的工具类
 *
 *  面试题：Collectios 和 Collections的区别?
 *
 * @author luozstart
 * @create 2022-12-16 13:08
 */

public class CollectionsTest {

    /*
    reverse(List):反转List中元素的顺序
    shuffle(List):对List集合元素进行随机排序
    sort(List):根据元素的自然顺序对只当List集合元素按升序排序
    sort(List,Comparator):将指定list集合中i处元素和j处元素进行交换



    Object max(Collection):根据元素的自然顺序，返回给定集合中的最大元素
    Object max(Collection ,Comparator):根据Comparator指定的顺序，返回给定集合中的最大元素
    Object min(Collection)
    Object min(Collection,Comparator)
    int frequency(Conllection,Object):返回指定集合中指定元素的出现次数
    void copy(List dest,List src):将src中的内容复制到dest中
    boolean replaceAll(List list,Object oldVal,Object newVal):使用新值替换List对象
     */
    @Test
    public void test1(){
        List list = new ArrayList();
        list.add(123);
        list.add(43);
        list.add(345);
        list.add(789);
        list.add(-1);
        System.out.println(list);

        //反转
        //Collections.reverse(list);

        //随机化处理
        //Collections.shuffle(list);

        //排序，按自然排序
//        Collections.sort(list);

        //交换
//        Collections.swap(list,0,2);

        //找到最大值,最小值
//        Collections.max(list);

        //找到指定元素出现的次数
//        Collections.frequency(list,123);

        //复制list(注意)
//        List dest = Arrays.asList(new Object[list.size()]);
//        Collections.copy(dest,list);
//        System.out.println(dest);

        System.out.println(list);

        //线程安全
        List list1 = Collections.synchronizedList(list);

    }

    @Test
    public void test2(){
        List list=new ArrayList();
        for (int i=0;i<5;i++){
            list.add((int)( Math.random()*100));
        }
        Collections.reverse(list);
        System.out.println(list);

        Collections.sort(list);
        Collections.reverse(list);
        System.out.println(list);
    }

    @Test
    public void test3(){
        System.out.println(-1*-1);
    }
}

class Stduent{
    private String name;
    private int score;
    private int id;

    public Stduent(String name, int score, int id) {
        this.name = name;
        this.score = score;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stduent stduent = (Stduent) o;
        return score == stduent.score && id == stduent.id && Objects.equals(name, stduent.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, score, id);
    }
}