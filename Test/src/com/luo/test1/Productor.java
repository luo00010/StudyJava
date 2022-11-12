package com.luo.test1;

import sun.applet.Main;

/**
 * @author luozstart
 * @create 2022-11-08 16:32
 */
public class Productor implements Runnable{
    private Clerk clerk;

    public Productor(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.add();
        }
    }
}

class Clerk{
    private int num;


    public synchronized void add() {
        if (num<20) {
            num++;
            System.out.println("开始生产第：" + num);
            notify();
        }else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void dle(){
        if (num>0) {
            System.out.println("消费第：" + num);
            num--;
            notify();
        }else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

class Customer implements Runnable{
    private Clerk clerk;

    public Customer(Clerk clerk) {
            this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println("开始消费");
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.dle();
        }

    }
}

class Test1{
    public static void main(String[] args) {
        Clerk c = new Clerk();
        Productor p = new Productor(c);
        Customer cu = new Customer(c);

        Thread t1 = new Thread(p);
        Thread t2 = new Thread(cu);

        t1.start();
        t2.start();
    }
}