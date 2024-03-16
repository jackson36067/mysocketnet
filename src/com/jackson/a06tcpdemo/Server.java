package com.jackson.a06tcpdemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

//TCP接收数据
public class Server {
    public static void main(String[] args) throws IOException {
        //    创建ServerSocket对象
//        创建对象时需要指定端口号,与发送数据的端口号一致
        ServerSocket ss = new ServerSocket(10000);

//        2.监听客户端的连接
        Socket socket = ss.accept();

//        3.从连接通道中获取输入流
        InputStream is = socket.getInputStream();
//        防止字节输入流读取中文时乱码,使用转换流将字节输入流转换成字符输入流
        InputStreamReader isr = new InputStreamReader(is);
//        使用缓冲流增加读取的效率
        BufferedReader br = new BufferedReader(isr);
        int b;
        while ((b = br.read()) != -1) {
            System.out.print((char) b);
        }

//        4.释放资源
        br.close();
        ss.close();
    }
}
