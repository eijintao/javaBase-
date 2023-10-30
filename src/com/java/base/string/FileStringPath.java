package com.java.base.string;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * mjt 梅锦涛
 * 2023/9/20
 *
 * @author mjt
 */
public class FileStringPath {

    public static void main(String[] args) {
        //String str = "F:\\ydzq\\zhrxYDZQy_ydzq-1.0.0\\config\\application.yml";
        String str = null;
        Path path = Paths.get(str);

        if (Files.exists(path)) {
            System.out.println("Path exists");
        } else {
            System.out.println("Path does not exist");
        }

    }
}
