package com.jackson.a01Inetaddressdemo;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class MyInetAddressDemo1 {
    /*
    获取ip的对象类 InetAddress 这个类还有两个子类,分别是Inet4Address(ipv4)以及Inet6Address(ipv6)
     * static InetAddress getByName(String host) 确认主机的IP地址,主机名称可以是机械名称,也可以是ip地址
     * String getHostName()  获取此IP地址的主机名
     * String getHostAddress()  返回文本显示中的IP地址字符串
     * */
    public static void main(String[] args) throws UnknownHostException {
//        InetAddress name = InetAddress.getByName("10.64.20.162");
        InetAddress name = InetAddress.getByName("jackson");
        System.out.println(name);

        String hostName = name.getHostName();
        System.out.println(hostName);

        String ip = name.getHostAddress();
        System.out.println(ip);

    }
}
