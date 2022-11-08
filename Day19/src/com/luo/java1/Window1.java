package com.luo.java1;

/**
 * @author luozstart
 * @create 2022-11-07 12:17
 */
//implements Runnable解决同步问题
public class Window1 implements Runnable{
    private int ticket = 100;
    Object obj = new Object();
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
