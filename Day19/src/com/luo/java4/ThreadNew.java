package com.luo.java4;

import sun.applet.Main;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 创建线程的方式三：实现Callable接口。----JDK5.0新增
 *
 * @author luozstart
 * @create 2022-11-08 20:43
 */

//1.创建一个实现Callable的实现类
class NumThread implements Callable{
    //2.实现call方法，将此线程需要执行的操作声明在call（）内
    @Override
    public Object call() throws Exception {
        int sum =0;
        for (int i=1;i<=100l;i++){
            if (i%2==0){
                System.out.println(i);
                sum+=i;
            }
        }
        return sum;

    }
}

public class ThreadNew {
    public static void main(String[] args) {
        //3.创建Callable接口实现类的对象
        NumThread numThread = new NumThread();
        //4.将次Callable接口实现类的对象闯到FutureTask构造器中。创建FutureTask的对象
        FutureTask futureTask = new FutureTask(numThread);
        //5.将FutureTask的对象作为参数传递到Thread类的构造器中，创建Thread对象，并调用start（）方法
        Thread thread = new Thread(futureTask);
        thread.start();
        try {
            //6.get()返回值即为FutureTask构造器参数Callable实现类重写的call（）的返回值
            Object obj = futureTask.get();
            System.out.println(obj);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
