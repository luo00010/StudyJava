package com.luo.java2;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * 例题3：从客户端发送文件给服务端，服务端保存到本地。并返回"发送成功"给客户端。
 * 并关闭相应的连接。
 *
 * @author luozstart
 * @create 2023-01-04 22:49
 */
public class TCPTest3 {
    @Test
    public void client(){
        Socket socket = null;
        OutputStream os = null;
        FileInputStream fis = null;
        InputStream is =null;
        ByteArrayOutputStream baos=null;
        try {
            socket = new Socket(InetAddress.getByName("127.0.0.1"),9045);

            os = socket.getOutputStream();

            fis = new FileInputStream("牛仔1.jpg");

            byte[] buffer = new byte[1024];
            int len;
            while ((len=fis.read(buffer))!=-1){
                os.write(buffer,0,len);
            }

            //关闭传输数据
            socket.shutdownOutput();

            //接收来自于服务器端的数据
            is = socket.getInputStream();
            baos = new ByteArrayOutputStream();
            byte[] bufferr = new byte[20];
            int len2;
            while ((len2 = is.read(bufferr))!=-1){
                baos.write(bufferr,0,len2);
            }
            System.out.println(baos.toString());


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket!=null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(os!=null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis!=null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is!=null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (baos!=null){
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void server(){
        ServerSocket ss = null;
        Socket accept = null;
        InputStream is = null;
        FileOutputStream fos = null;
        OutputStream os = null;
        try {
            ss = new ServerSocket(9045);

            accept = ss.accept();

            is = accept.getInputStream();

            fos = new FileOutputStream("Test3.jpg");

            byte[] buffer = new byte[1024];
            int len;
            while ((len=is.read(buffer))!=-1){
                fos.write(buffer,0,len);
            }

            //反馈
            os = accept.getOutputStream();
            os.write("照片已收到！".getBytes());


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ss!=null){
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (accept!=null){
                try {
                    accept.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is!=null){
                try {
                    is.close();
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
            if (os!=null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
