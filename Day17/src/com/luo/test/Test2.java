package com.luo.test;

/**
 * @author luozstart
 * @create 2022-11-06 14:07
 */
public class Test2 {
    public static void main(String[] args) {
        //创建Runnable子类的对象
        MThread m1 = new MThread();
        //将此对象传递到Thread的构造器中
        Thread t1 = new Thread(m1);
        //调用start启动线程
        t1.start();


        //再创建一个线程，同样遍历100以内的偶数
        Thread t2 = new Thread(m1);
        t2.start();
    }
}

//1.创建Runnable实现类
class MThread implements Runnable {
    //实现run方法
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }

    }
}