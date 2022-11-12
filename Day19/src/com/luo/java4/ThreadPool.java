package com.luo.java4;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author luozstart
 * @create 2022-11-08 21:10
 */

class NumberThread implements Runnable{

    @Override
    public void run() {
        for (int i=0;i<=100;i++){
            if (i%2==0){
                System.out.println(i);
            }
        }
    }
}


public class ThreadPool {
    public static void main(String[] args) {
        //1，提供指定线程数量的线程池
        ExecutorService service = Executors.newFixedThreadPool(10);
        //2.执行指定的线程的操作。需要提供实现Runnable接口或Callable接口的实现类的对象
        service.execute(new NumberThread());//适合使用于Runnable
        //service.submit(Callable callable);//适用于Callable

        //3.关闭线程池
        service.shutdown();//关闭连接池
    }
}
