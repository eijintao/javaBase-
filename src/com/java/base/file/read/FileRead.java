package com.java.base.file.read;

import java.io.FileReader;

/**
 * mjt 梅锦涛
 * 2022/11/24
 *
 * @author mjt
 */
public class FileRead {

    public static void main(String[] args) {
        String file = "f:\\a.txt";
        FileReader fileReader = null;
        char[] chars = new char[8];
        try {
            fileReader =  new FileReader(file);
            fileReader.read(chars);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
