package com.java.base.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * mjt 梅锦涛
 * 2023/10/18
 *
 * @author mjt
 */
public class SmsserverTest {

    public static String SMS(String _url, String lx, String username, String password, String phoneNum, String Content, String bmlx) {
        String returninfo = "发送成功";

        try {
            String encodedContent = (bmlx == null || bmlx.isEmpty()) ? URLEncoder.encode(Content) : URLEncoder.encode(Content, bmlx);
            String strurl = String.format("%s?lx=%s&DLZH=%s&DLMM=%s&SJHM=%s&XXNR=%s&FSFS=0",
                    _url, URLEncoder.encode(lx, "UTF-8"), URLEncoder.encode(username, "UTF-8"),
                    URLEncoder.encode(password, "UTF-8"), URLEncoder.encode(phoneNum, "UTF-8"), encodedContent);

            URL url = new URL(strurl);
            HttpURLConnection huc = (HttpURLConnection) url.openConnection();
            huc.setRequestMethod("GET");
            huc.setRequestProperty("Accept", "*/*");
            huc.setRequestProperty("User-Agent", "Profile/MIDP-2.0 Configuration/CLDC-1.0");
            huc.setRequestProperty("Content-Language", "en-US");
            huc.setRequestProperty("Accept-Language", "zh-CN");
            huc.setRequestProperty("Content-type", "text/html");
            System.out.println("发送短信的url :" + strurl);

            try (BufferedReader br = new BufferedReader(new InputStreamReader(huc.getInputStream(), (bmlx != null && !bmlx.isEmpty()) ? bmlx : "UTF-8"))) {
                String line;
                while ((line = br.readLine()) != null) {
                    returninfo = line;
                }
            }

            huc.connect();
        } catch (IOException e) {
            e.printStackTrace(); //或者使用日志工具
            return "发送失败，原因：" + e.getMessage();
        }

        return returninfo;
    }


    public static void main(String[] args) throws IOException {
        //if(args.length < 7) {
        //    System.out.println("Usage: java SmsSender <url> <lx> <username> <password> <phoneNum> <content> <bmlx>");
        //    return;
        //}

        //String result = SMSServer.SMS(args[0], args[1], args[2], args[3], args[4], args[5], args[6]);
        String result = SMSServer.SMS("11", "22", "33", "44", "55", "66", "utf-8");
        System.out.println("Result: " + result);
    }
}
