package com.java.base.internet;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * asus 梅锦涛
 * 2022/5/1
 *
 * @author mjt
 */
public class InetAddressTest {

    /**
     * 详情见 java核心技术卷1 的socket编程。网络那一章节
     * @param args
     * @throws UnknownHostException
     */
    public static void main(String[] args) throws UnknownHostException {
        if (args.length > 0) {
            String host = args[0];
            InetAddress[] allByName = InetAddress.getAllByName(host);
            for (InetAddress inetAddress : allByName) {
                System.out.println(inetAddress);
            }
        } else {
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println(localHost);
        }
    }

}
