package com.luo.java;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author luozstart
 * @create 2023-01-01 22:23
 */
public class RandomAccessFileTest {

    @Test
    public void test1(){
        RandomAccessFile raf1 = null;
        RandomAccessFile raf2 = null;
        try {
            raf1 = new RandomAccessFile(new File("牛仔.jpg"),"r");
            raf2 = new RandomAccessFile(new File("牛仔1.jpg"),"rw");

            byte[] buffer = new byte[1024];
            int len ;
            while ((len=raf1.read(buffer))!=-1){
                raf2.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (raf1!=null){
                try {
                    raf1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (raf2!=null){
                try {
                    raf2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Test
    public void test2(){
        RandomAccessFile raf1 = null;
        try {
            raf1 = new RandomAccessFile("hello.txt","rw");

            raf1.seek(3);   //将覆盖初始指针赋值
            raf1.write("luozheng".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (raf1!=null){
                try {
                    raf1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }


    /*\
    实现插入效果
     */
    @Test
    public void test3(){

        RandomAccessFile raf1 = null;
        try {
            raf1 = new RandomAccessFile("hello.txt","rw");

            raf1.seek(3);

            //保存指针3以后的字符
            StringBuilder builder = new StringBuilder((int) new File("hello.txt").length());
            byte[] buffer = new byte[20];
            int len;
            while ((len=raf1.read(buffer))!=-1){
                builder.append(new String(buffer,0,len));
            }
            //重置指针位置
            raf1.seek(3);

            //写入要添加的数据
            raf1.write("xyzggg".getBytes());
            //写入buileder中的数据
            raf1.write(builder.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (raf1!=null){
                try {
                    raf1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
