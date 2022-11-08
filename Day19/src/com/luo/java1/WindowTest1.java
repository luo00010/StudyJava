package com.luo.java1;

/**
 * @author luozstart
 * @create 2022-11-07 12:17
 */
public class WindowTest1 {
    public static void main(String[] args) {
        Window1 w1 = new Window1();
        Thread t1 = new Thread(w1);
        Thread t2 = new Thread(w1);
        Thread t3 = new Thread(w1);
        t1.setName("售票窗口一");
        t2.setName("售票窗口二");
        t3.setName("售票窗口三");
        t1.start();
        t2.start();
        t3.start();
    }
}
