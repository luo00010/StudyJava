package com.luo.test2;

import org.junit.Test;

import java.io.*;

/**
 *  -encoding UTF-8
 *
 * @author luozstart
 * @create 2022-12-24 19:10
 */
public class InputOutputStreamTest {
    public static void main(String[] args) throws IOException {
        //1.造地址
        File inf = new File("E:\\IO\\a.txt");
        System.out.println(inf.getAbsolutePath());
        File outf = new File(inf.getParent()+"\\复制品1.txt");
        //2.造流
        //2.1造一个输入流，与缓冲流
        FileInputStream fis = new FileInputStream(inf);
        BufferedInputStream bis = new BufferedInputStream(fis);
        //2.2造一个输出流,与缓存流
        FileOutputStream fos = new FileOutputStream(outf);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        //3.读写操作
        //3.1造一个载体
        byte[] b = new byte[1024];
        //记载每次的读取个数
        int len;
        while ((len=bis.read(b))!=-1){
            bos.write(b,0,len);
        }


        //4.关闭流
        bis.close();
        bos.close();
    }


}





































