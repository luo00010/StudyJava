package com.luo.exer;

/**
 * @author luozstart
 * @create 2022-11-05 20:30
 */
public class ThreadDemo {
    public static void main(String[] args) {
        MyThread m1 = new MyThread("线程8");
        Thread.currentThread().setName("主线程");
        m1.start();
        for (int i=0;i<100;i++){
            if (i%2!=0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
            if (i==20){
                try {
                    m1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class MyThread extends Thread{
    public MyThread(String name){
        super(name);
    }
    @Override
    public void run() {
        for (int i=0;i<100;i++){
            if (i%2==0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}

