package com.luo.java;

import org.junit.Test;

import java.io.*;

/**
 *
 * 缓冲流
 *
 *
 *
 * @author luozstart
 * @create 2022-12-23 14:15
 */
public class BufferedTest {

    @Test
    public void testBuffedStream(){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            //1.造文件
            File stcFile = new File("牛仔.jpg");
            File destFile = new File("牛仔3.jpg");
            //2.造流
            //2.1造节点流
            fis = new FileInputStream(stcFile);
            fos = new FileOutputStream(destFile);
            //2.2 造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);


            //3.读写

            byte[] buffer = new byte[10];
            int len;
            while ((len = bis.read(buffer))!=-1){
                bos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.资源关闭
            //要求：先关闭外层的流，再关闭内层的流
            if (bis!=null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bos!=null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            //说明：关闭外层流的同时，内层流也会自动的进行关闭。关于内层流的关闭，我们可以省略。
//            if (fis!=null) {
//                try {
//                    fis.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            if (fos!=null) {
//                try {
//                    fos.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
        }
    }
}
