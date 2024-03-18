package com.jackson.a02udpdemo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class SendMassageDemo {
    public static void main(String[] args) throws IOException {
//        创建DatagramSocket
//        细节:可以指定发送到的端口号,不指定端口号就会随机端口号
        DatagramSocket ds = new DatagramSocket();
//        创建DatagramPacket
//        参数需要指定传输的东西(byte数组),长度(传输数组的长度),ip地址,端口号
//        字节数组
        String str = "瘫痪仔是屌毛";
        byte[] bytes = str.getBytes();
//        ip地址
        InetAddress address = InetAddress.getByName("127.0.0.1");
//        端口号:
        int port = 10086;

        DatagramPacket dp = new DatagramPacket(bytes, bytes.length, address, port);

//        发送信息
        ds.send(dp);

//        释放资源
        ds.close();
    }
}
