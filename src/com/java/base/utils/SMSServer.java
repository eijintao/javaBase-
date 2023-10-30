package com.java.base.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * mjt 梅锦涛
 * 2023/10/16
 *
 * @author mjt
 */
public class SMSServer {

    /**
     * @param _url       : 发送短信接口服务；
     * @param lx        : 处理类型；
     * @param username: 接口认证的用户名
     * @param password: 接口认证的密码
     * @param phoneNum  : 手机号吗
     * @param Content:  短信内容；
     * @param bmlx:     编码类型；
     * @throws IOException
     */
    public static String SMS(String _url, String lx, String username, String password, String phoneNum, String Content, String bmlx) throws IOException {
        String returninfo = "发送成功";
        String content = "";
        //15901245791
        try {
            //content = java.net.URLEncoder.encode(Content, bmlx);
            if (bmlx == null) {
                content = Content;
            } else if (bmlx.equals("")) {
                content = java.net.URLEncoder.encode(Content);
            } else {
                content = java.net.URLEncoder.encode(Content, bmlx);
            }
            String strurl = _url + "?lx=" + lx + "\\&DLZH=" + username + "\\&DLMM=" + password + "\\&SJHM=" + phoneNum + "\\&XXNR=" + content +"\\&FSFS=0";
            URL url = new URL(strurl);
            HttpURLConnection huc = (HttpURLConnection) url.openConnection();
            huc.setRequestMethod("GET");
            huc.setRequestProperty("Accept", "*/*");
            huc.setRequestProperty("User-Agent", "Profile/MIDP-2.0 Configuration/CLDC-1.0");
            huc.setRequestProperty("Content-Language", "en-US");
            huc.setRequestProperty("Accept-Language", "zh-CN");
            huc.setRequestProperty("Content-type", "text/html");
            //log.info("发送短信的url :" + strurl);
            System.out.println("发送短信的url :" + strurl);
            BufferedReader br = null;
            if (bmlx != null || bmlx != "") {
                br = new BufferedReader(new InputStreamReader(huc.getInputStream(),bmlx));
            } else {
                br = new BufferedReader(new InputStreamReader(huc.getInputStream()));
            }
            String line;
            while ((line = br.readLine()) != null) {
                returninfo = line;
            }
            huc.connect();
            br.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return returninfo;
    }

    public static void main(String[] args) throws IOException {
        if(args.length < 7) {
            System.out.println("Usage: java SmsSender <url> <lx> <username> <password> <phoneNum> <content> <bmlx>");
            return;
        }

        String result = SMSServer.SMS(args[0], args[1], args[2], args[3], args[4], args[5], args[6]);
        System.out.println("Result: " + result);
    }



}
