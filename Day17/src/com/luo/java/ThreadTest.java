package com.luo.java;

/**
 * @author luozstart
 * @create 2022-11-05 20:09
 */
public class ThreadTest {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start();
        for (int i=0;i<100;i++){
            if (i%2==0){
                System.out.println(i+"****");
            }
        }
        System.out.println(Thread.currentThread().getName());
    }
}


class MyThread extends Thread {
    @Override
    public void run() {
        for (int i=0;i<100;i++){
            if (i%2==0){
                System.out.println(i);
            }
        }
    }
}
