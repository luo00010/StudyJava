package com.luo.test;

/**
 * @author luozstart
 * @create 2022-11-06 13:42
 */
public class Test {
    public static void main(String[] args){
        addSum1 a1 = new addSum1();
        Thread.currentThread().setName("主线程");
        a1.start();
        a1.setName("小线程");
        for (int i=0;i<100;i++){
            if (i%2!=0){
                System.out.println(Thread.currentThread().getName()+":"+i);
                try {
                    Thread.currentThread().sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(Thread.currentThread().isAlive());
    }
}

class addSum1 extends Thread{
    @Override
    public void run() {
        for (int i=0;i<100;i++){
            if (i%2==0){
                System.out.println(getName()+":"+i);
            }
            if (i%20==0){
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
