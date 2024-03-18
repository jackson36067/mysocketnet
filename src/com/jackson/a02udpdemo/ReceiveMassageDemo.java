package com.jackson.a02udpdemo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ReceiveMassageDemo {
    public static void main(String[] args) throws IOException {
//            接受数据,创建DatagramSocket对象
//        细节:需要指定前面在发送数据时指定的端口号
        DatagramSocket ds = new DatagramSocket(10086);
//        创建字节数组用于存放接受的数据
        byte[] bytes = new byte[1024];
//        创建DatagramPocket对象
        DatagramPacket dp = new DatagramPacket(bytes, bytes.length);
//        接收数据
//        ds.receive(dp);

//        获取传输的ip地址
        InetAddress address = dp.getAddress();

//        获取接受的信息
        byte[] data = dp.getData();

//        获取接受信息的长度
        int length = dp.getLength();

//        获取传输信息的端口号
        int port = dp.getPort();

        System.out.println("接收到数据" + new String(data, length));
        System.out.println("该数据从" + address + "这台电脑中的" + port + "端口接收的");
//        释放资源
        ds.close();
    }
}
