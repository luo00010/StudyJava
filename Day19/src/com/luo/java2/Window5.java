package com.luo.java2;

/**
 * @author luozstart
 * @create 2022-11-07 16:40
 */
class WindowTest5 {
    public static void main(String[] args) {
        Window5 w5 = new Window5();
        Thread t1 = new Thread(w5);
        Thread t2 = new Thread(w5);
        Thread t3 = new Thread(w5);
        t1.setName("售票窗口一");
        t2.setName("售票窗口二");
        t3.setName("售票窗口三");
        t1.start();
        t2.start();
        t3.start();
    }
}

class Window5 implements Runnable{
    private int ticket = 100;
    Object obj = new Object();
    @Override
    public void run() {
        while (true) {
            if (ticket>0) {
                show();
            }else break;
        }
    }
    private synchronized void show(){
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + ":" + ticket);
                ticket--;
            }
    }
}