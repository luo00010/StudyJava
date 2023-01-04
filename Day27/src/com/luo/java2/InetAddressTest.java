package com.luo.java2;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author luozstart
 * @create 2023-01-02 17:01
 */
public class InetAddressTest {

    public static void main(String[] args) {
        try {
            InetAddress inet1 = InetAddress.getByName("192.168.1.1");
            System.out.println(inet1);

            InetAddress baidu = InetAddress.getByName("www.baidu.com");
            System.out.println(baidu);

            //获取本地ip
            InetAddress inet3 = InetAddress.getLocalHost();
            System.out.println(inet3);


            //getHostName():获取域名
            System.out.println(baidu.getHostName());

            //getHostAddress():获取ip地址
            System.out.println(baidu.getHostAddress());

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
