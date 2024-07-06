package com.java.base.ip;

/**
 * mjt 梅锦涛
 * 2024/1/26
 *
 * @author mjt
 */
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class GetLocalIpAddress {
    public static void main(String[] args) {
        try {
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println("Local IP Address: " + localHost.getHostAddress());

            List<String> ipAddresses = new ArrayList<>();
            // 获取网络接口
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();

            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterface = networkInterfaces.nextElement();
                Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();

                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddress = inetAddresses.nextElement();


                    // 过滤掉127.0.0.1和IPv6地址
                    if (!inetAddress.isLoopbackAddress() && inetAddress.isSiteLocalAddress()) {
                        ipAddresses.add(inetAddress.getHostAddress());
                    }
                }
            }

            // 获取并打印最后一个IP地址
            if (!ipAddresses.isEmpty()) {
                String lastIpAddress = ipAddresses.get(ipAddresses.size() - 1);
                System.out.println("Last Local IP Address: " + lastIpAddress);
            } else {
                System.out.println("No local IP address found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
