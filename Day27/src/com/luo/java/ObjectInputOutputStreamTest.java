package com.luo.java;

import org.junit.Test;

import java.io.*;

/**
 * 对象流的使用
 *
 * @author luozstart
 * @create 2023-01-01 16:55
 */
public class ObjectInputOutputStreamTest {

    /*
    序列化过程：将内存种的java对象保存倒磁盘中或通过网络传输出去(ObjectOutputStream)
     */
    @Test
    public void testObjectOutputStream(){
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("object.dat"));

            oos.writeObject(new String("我爱北京天安门"));

            oos.flush();//刷新操作
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(oos!=null){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }


    /*
    反序列化
     */
    @Test
    public void testObjectInputStream(){
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("object.dat"));

            Object obj = ois.readObject();
            System.out.println((String) obj);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois!=null){
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
