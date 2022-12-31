package com.luo.java;

import org.junit.Test;

import java.io.*;
import java.lang.reflect.Field;

/**
 * @author luozstart
 * @create 2022-12-22 23:35
 */
public class FileInputOutputStreamTest {

    @Test
    public void testFileInputStream() throws IOException {
        FileInputStream fis = null;
        try {
            //1.造文件
            File file =new File("hello.txt");

            //2.造流
            fis = new FileInputStream(file);

            //3.读数据
            byte[] buffer = new byte[5];
            int len;
            while((len=fis.read(buffer))!=-1){
                String str = new String(buffer,0,len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis!=null){
                //4.关闭资源
                fis.close();
            }
        }

    }

    /*
    实现对图片的复制操作
     */
    @Test
    public void testFileInputOutStream(){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            //造File
            File srcFile = new File("牛仔.jpg");
            File destFile = new File("牛仔2.jpg");

            //造流
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);

            //读写
            byte[] buffer = new byte[5];
            int len;
            while((len=fis.read(buffer))!=-1){
                fos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis!=null){
                //4.清理
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos!=null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
