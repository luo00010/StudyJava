package com.luo.java3;

import com.luo.java2.Window;

import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * 解决线程安全问题的方式三：lock锁 ---JDK5.0新增
 *
 * @author luozstart
 * @create 2022-11-07 19:00
 */

class window implements Runnable{
    private int t = 100;
    //1.创建ReenreantLock
    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
            try {
                //2,调用锁定方法lock()
                lock.lock();
                while (true) {
                    if (t > 0) {
                        System.out.println(Thread.currentThread().getName() + ":" + t);
                    } else break;
                }
            } finally{
                //3.调用解锁方法：unlock()
                lock.unlock();
            }

            }
}

public class LockTest {
    public static void main(String[] args) {
        Window w1 = new Window();
        Thread t1 = new Thread(w1);
        Thread t2 = new Thread(w1);
        Thread t3 = new Thread(w1);

        t1.setName("窗口一");
        t2.setName("窗口二");
        t3.setName("窗口三");

        t1.start();
        t2.start();
        t3.start();
    }
}
