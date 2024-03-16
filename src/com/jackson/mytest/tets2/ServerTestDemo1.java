package com.jackson.mytest.tets2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

//实现使用tcp接收数据,并反馈一条信息给客户端
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
        //细节:read方法会从连接通道中读取数据
        //连接通道没有销毁那么就会一直读取数据
        //导致死循环,下面的代码无法执行
        //需要有一个结束标记,此时循环才会结束
        //那么就绪要在客户端写出结束标记
        while ((b = br.read()) != -1) {
            System.out.print((char) b);
        }

        //回写数据
        OutputStream os = socket.getOutputStream();
        String str = "我也好开心!";
        os.write(str.getBytes());

        //释放资源
        socket.close();
        ss.close();
    }
}
