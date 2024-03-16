package com.jackson.a06tcpdemo;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    //    TCP协议  发送数据
    public static void main(String[] args) throws IOException {
        //    1.创建Socket对象
//    细节:创建对象时同时会连接服务端 ,连接不上会报错
//        创建对象时要指定ip,以及端口号
        Socket socket = new Socket("127.0.0.1", 10000);
//        2.从连接通道中获取输出流发送数据
        OutputStream os = socket.getOutputStream();
        os.write("瘫痪仔是屌毛".getBytes());

//        3.释放资源
        os.close();
        socket.close();
    }
}
