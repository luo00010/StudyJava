package com.luo.java;

import org.junit.Test;

import java.io.*;

/**
 * @author luozstart
 * @create 2022-12-23 19:33
 */
public class InputStreamReaderTest {

    @Test
    public void test1(){
        FileInputStream fis = null;
        InputStreamReader isr = null;
        OutputStreamWriter osw = null;
        try {
            fis = new FileInputStream("hello.txt");
            isr = new InputStreamReader(fis,"UTF-8");
            osw = new OutputStreamWriter(new FileOutputStream("hello2.txt"));

            char[] cbuf = new char[5];
            int len;
            while ((len = isr.read(cbuf))!=-1){
                osw.write(cbuf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (isr!=null){
                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (osw!=null){
                try {
                    osw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
