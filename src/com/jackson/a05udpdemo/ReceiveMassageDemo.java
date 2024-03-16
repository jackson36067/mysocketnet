package com.jackson.a05udpdemo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ReceiveMassageDemo {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket(10000);
        byte[] bytes = new byte[1024];
        DatagramPacket dp = new DatagramPacket(bytes, bytes.length);
        ds.receive(dp);
        byte[] data = dp.getData();
        System.out.println(new String(data, 0, dp.getLength()));
    }
}
