package com.luo.java3;

/**
 * 线程的通信例子：使用两个线程打印1-100.线程1，线程2 交替打印
 *
 * @author luozstart
 * @create 2022-11-08 11:53
 */
public class CommunicationTest {
    public static void main(String[] args) {
        Test3_1 te1 = new Test3_1();
        Thread t1 = new Thread(te1);
        Thread t2 = new Thread(te1);

        t1.setName("进程1");
        t2.setName("进程2");


        t1.start();
        t2.start();

    }
}


class Numer implements Runnable {
    private int num = 1;

    @Override
    public void run() {
        while (true) {

            synchronized (this) {
                //唤醒
                notify();

                if (num <= 100) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":" + num);
                    num++;
                    try {
                        //使得调用如下wait（）方法的线程进入阻塞状态
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else break;

            }
        }
    }
}