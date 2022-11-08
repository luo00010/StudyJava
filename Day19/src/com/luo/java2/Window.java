package com.luo.java2;

import com.luo.java1.Window1;

/**
 * @author luozstart
 * @create 2022-11-07 16:19
 */
//extends Thread方式解决同步问题
public class Window extends Thread{
    private static int ticket = 100;
    private static Object obj = new Object();
    @Override
    public void run() {
        while (true) {
            synchronized(obj) {
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + ":" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}

class WindowTest {
    public static void main(String[] args) {
        Thread t1 = new Window();
        Thread t2 = new Window();
        Thread t3 = new Window();
        t1.setName("售票窗口一");
        t2.setName("售票窗口二");
        t3.setName("售票窗口三");
        t1.start();
        t2.start();
        t3.start();
    }
}