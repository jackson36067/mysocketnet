package com.jackson.mytest.test1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

//实现使用tcp进行多收(一次接收多条信息)
public class ServerTestDemo1 {
    public static void main(String[] args) throws IOException {
        //创建ServerSocket对象,指定连接的端口号
        ServerSocket ss = new ServerSocket(10000);
        //等待发送数据
        Socket socket = ss.accept();
        //获取输入流,接收数据
        InputStream is = socket.getInputStream();
        //使用转换流将字节流转换成字符流,防止接收中文时乱码
        InputStreamReader isr = new InputStreamReader(is);
        //使用字符缓冲流加快接受的效率
        BufferedReader br = new BufferedReader(isr);
        //定义变量用于接收数据
        int b;
        while ((b = br.read()) != -1) {
            System.out.print((char) b);
            System.out.print("");
        }
        //释放资源
        br.close();
        ss.close();
    }
}
