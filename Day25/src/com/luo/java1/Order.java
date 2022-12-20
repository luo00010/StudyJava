package com.luo.java1;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义泛型
 *
 * @author luozstart
 * @create 2022-12-20 22:10
 */
public class Order<T> {
    String orderName;
    int orderId;

    //类的内部接口可以使用类的泛型
    T orderT;

    public Order(){};

    public Order(String orderName,int orderId,T orderT){
        this.orderId = orderId;
        this.orderName=orderName;
        this.orderT = orderT;
    }

    public int getOrderId() {
        return orderId;
    }

    public T getOrderT() {
        return orderT;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setOrderT(T orderT) {
        this.orderT = orderT;
    }

    //泛型方法
    public <E> List<E> copyFromArrayToList(E[] arr){
        ArrayList<E> list = new ArrayList();
        for (E e :arr){
            list.add(e);
        }
        return  list;
    }
}
