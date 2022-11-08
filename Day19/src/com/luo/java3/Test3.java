package com.luo.java3;

/**
 * @author luozstart
 * @create 2022-11-08 11:45
 */
public class Test3 {
    public static void main(String[] args) {
        Test3_1 te1 = new Test3_1();
        Thread t1 = new Thread(te1);
        Thread t2 = new Thread(te1);
        Thread t3 = new Thread(te1);

        t1.setName("进程一");
        t2.setName("进程二");
        t3.setName("进程三");

        t1.start();
        t2.start();
        t3.start();
    }
}
class Test3_1 implements Runnable{
    private int num=1;
    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (this) {
                if (num <= 100) {
                    System.out.println(Thread.currentThread().getName() + ":" + num);
                    num++;
                } else break;
            }
        }
    }
}