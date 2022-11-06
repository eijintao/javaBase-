package com.java.base.file;

import java.io.File;
import java.io.IOException;

/**
 * asus 梅锦涛
 * 2022/10/30
 *
 * @author mjt
 */
public class CreateFileTest {

    public static void main(String[] args) throws IOException {
        File file = new File("D://test.txt");
        try {
            file.createNewFile();
            System.out.println("file create success");
        } catch (IOException e) {
            System.out.println("create fail");
            e.printStackTrace();
        }

    }

}
