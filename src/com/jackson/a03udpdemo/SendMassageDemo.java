package com.jackson.a03udpdemo;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/*
* 实现聊天室
* 键盘输入你想说的话,发送出去
* 接收到886时,停止聊天
* */
public class SendMassageDemo {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入你想要说的话");
            String str = sc.nextLine();
            byte[] bytes = str.getBytes();
            InetAddress address = InetAddress.getByName("127.0.0.1");
            Integer port = 10086;
            DatagramPacket dp = new DatagramPacket(bytes, bytes.length, address, port);
            ds.send(dp);
            if (str.equals("886")) {
                break;
            }
        }
        ds.close();
    }
}
