package com.luo.java1;

import org.junit.Test;

import java.util.List;

/**
 * 如何自定义泛型结构：泛型类，泛型接口，泛型方法。见下述代码
 *
 * 1.关于自定义泛型类，泛型接口
 *
 * @author luozstart
 * @create 2022-12-20 22:16
 */
public class GenerucTest1 {
    @Test
    public void test1(){
        //如果自定义了泛型类，实例化没有指明类的泛型，则认为次泛型类型为Object类型
        //要求：如果大家定义了类的带泛型的，建议在实例化时要指明类的泛型
        Order order = new Order();


        //建议：实例化时指明类的泛型
        Order<String> objectOrder = new Order<>("order",110,"AA");
        objectOrder.setOrderT("BB");

    }

    //测试泛型方法
    @Test
    public void test2(){
        Order<String> objectOrder = new Order<>();
        Integer[] arr = {1, 2, 3, 4};
        //泛型方法在调用时，指明泛型参数的类型
        List<Integer> list = objectOrder.copyFromArrayToList(arr);

        System.out.println(list);
    }
}