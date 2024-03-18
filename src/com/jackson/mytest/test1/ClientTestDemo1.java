package com.jackson.mytest.test1;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

//使用tcp进行多发(多次发送数据)
public class ClientTestDemo1 {
    public static void main(String[] args) throws IOException {
        //        创建socket对象
        //        创建对象时要指定ip,以及端口号
        InetAddress address = InetAddress.getByName("127.0.0.1");
        int port = 10000;
        Socket socket = new Socket(address, port);
        //获取输出流,输出数据
        OutputStream os = socket.getOutputStream();
        //实现多发功能
        Scanner sc = new Scanner(System.in);
        while (true) {
            String s = sc.nextLine();
            byte[] bytes = s.getBytes();
            os.write(bytes);
            if (s.equals("886")) {
                break;
            }
        }
        //释放资源
        os.close();
        socket.close();
    }
}
