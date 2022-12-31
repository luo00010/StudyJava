package com.luo.java;

import org.junit.Test;

import java.io.*;

/**
 * @author luozstart
 * @create 2022-12-22 21:50
 */
public class FileReaderWriterTest {
    /*
    将hello.txt文件内容读入程序中，并输入到控制台
     */
    @Test
    public void testFileReader(){
        FileReader fr = null;
        try {
            //1.实例化File类的对象，指明要操作的文件
            File file = new File("hello.txt");
            //2.提供具体的流
            fr = new FileReader(file);

            //3.数据的读入
            //read():返回读入的一个字符。如果达到文件末尾，返回-1
            int data = fr.read();
            while (data !=-1){
                System.out.print((char) data);
                data = fr.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //4.流的关闭操作
            try {
                if (fr!=null) fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testFileReader1(){
        FileReader fr =null;
        try {
            //1.File类的实例化
            File  file = new File("hello.txt");
            //2.流的实例化
            fr = new FileReader(file);
            //3.读入的操作
            char[] cbuf = new char[5];
            int len;
            while ((len = fr.read(cbuf))!=-1){
                //方式一：
//                for (int i=0;i<len;i++){
//                    System.out.print(cbuf[i]);
//                }
                //方式二：
                String str = new String(cbuf,0,len);
                System.out.print(str);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }finally{
            if (fr!=null){
                //4.资源的关闭
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*
    从内存中写出数据到硬盘的文件里
     */
    @Test
    public void test3(){
        FileWriter fw = null;
        try {
            //1.提供File类的对象，指明写出到的文件
            File fiel = new File("hello1.txt");

            //2.提供FileWriter的对象，用于数据的写出
            fw = new FileWriter(fiel,true);

            //3.写出的操作
            fw.write("I hava a dream!\n");
            fw.write("you need to hava a dream!");
        } catch (IOException e){
            e.printStackTrace();
        }finally {
            if (fw!=null){
                //4.流的关闭
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Test
    public void test4(){
        FileReader fr = null;
        FileWriter fw = null;
        try {
            //1.创建File类的对象，指明读入和写出的文件
            File srcFile = new File("hello.txt");
            File destFile = new File("hello1.txt");

            //2.创建输入流的输出流的对象
            fr = new FileReader(srcFile);
            fw = new FileWriter(destFile);
            //3.数据的读入和写出操作
            char[] cbuf = new char[5];
            int len;
            while ((len=fr.read(cbuf))!=-1){
                fw.write(cbuf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fr!=null){
                //4.关闭流资源
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fw!=null){
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
