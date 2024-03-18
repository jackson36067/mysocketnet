package com.jackson.mytest.test2;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

//使用tcp发送一条信息
public class ClientTestDemo1 {
    public static void main(String[] args) throws IOException {
        //创建socket对象
        //创建对象时要指定ip,以及端口号
        InetAddress address = InetAddress.getByName("127.0.0.1");
        int port = 10000;
        Socket socket = new Socket(address, port);
        //获取输出流,输出数据
        OutputStream os = socket.getOutputStream();
        String str = "今天好开心!";
        os.write(str.getBytes());

        //写出一个结束标记
        socket.shutdownOutput();

        //接收服务端反馈的数据
        InputStream is = socket.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        int b;
        while ((b = br.read()) != -1) {
            System.out.print((char) b);
        }

        //释放资源
        socket.close();
    }
}
