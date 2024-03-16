package com.jackson.a05udpdemo;

import java.io.IOException;
import java.net.*;

//广播:
//属于局域网内的都可以接收到信息
//广播的ip只有一个255.255.255.255
public class SendMassageDemo {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket();
        String str = "你好";
        byte[] bytes = str.getBytes();
        InetAddress address = InetAddress.getByName("255.255.255.255");
        int port = 10000;
        DatagramPacket dp = new DatagramPacket(bytes, bytes.length, address, port);
        ds.send(dp);
        ds.close();
    }
}
