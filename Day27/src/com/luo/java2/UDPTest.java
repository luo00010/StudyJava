package com.luo.java2;

import org.junit.Test;

import java.io.IOException;
import java.net.*;

/**
 * @author luozstart
 * @create 2023-01-05 0:28
 */
public class UDPTest {

    //发送端
    @Test
    public void sender() throws IOException {
        DatagramSocket socket = new DatagramSocket();

        String str = "我是UDP方式发送的数据";
        byte[] data = str.getBytes();
        InetAddress inet = InetAddress.getByName("127.0.0.1");
        DatagramPacket packet = new DatagramPacket(data,data.length,inet,7788);

        socket.send(packet);

        socket.close();
    }

    //接收端
    @Test
    public void receiver() throws IOException {
        DatagramSocket socket = new DatagramSocket(7788);

        byte[] buffer = new byte[100];
        DatagramPacket packet = new DatagramPacket(buffer,0,buffer.length);


        socket.receive(packet);

        System.out.println(new String(packet.getData(),0,packet.getLength()));

        socket.close();
    }
}
