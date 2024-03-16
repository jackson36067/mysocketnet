package com.jackson.a04udpdemo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/*
组播就是一个地方发送数据,多个地方都能接收
* 组播的地址范围是224.0.0.0~235.255.255.255
实现组播需要使用MulticastSocket当作发送信息的快递公司
* */
public class SendMassageDemo {
    public static void main(String[] args) throws IOException {
        MulticastSocket ms = new MulticastSocket();
        String str = "你好";
        byte[] bytes = str.getBytes();
        InetAddress address = InetAddress.getByName("224.0.0.1");
        int port = 10000;
        DatagramPacket dp = new DatagramPacket(bytes, bytes.length, address, port);
        ms.send(dp);
        ms.close();
    }
}
