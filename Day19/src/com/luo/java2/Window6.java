package com.luo.java2;

/**
 * @author luozstart
 * @create 2022-11-07 16:46
 */
//extends Thread方式解决同步问题
public class Window6 extends Thread{
    private static int ticket = 100;
    private static Object obj = new Object();
    @Override
    public void run() {
        while (true) {
                if (ticket > 0) {
                    show();
                } else {
                    break;
                }
        }
    }
    public synchronized void show(){
        if (ticket > 0) {
            System.out.println(Thread.currentThread().getName() + ":" + ticket);
            ticket--;
        }
    }
}

class WindowTest6 {
    public static void main(String[] args) {
        Thread t1 = new Window6();
        Thread t2 = new Window6();
        Thread t3 = new Window6();
        t1.setName("售票窗口一");
        t2.setName("售票窗口二");
        t3.setName("售票窗口三");
        t1.start();
        t2.start();
        t3.start();
    }
}