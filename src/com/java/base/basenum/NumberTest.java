package com.java.base.basenum;

import com.sun.xml.internal.ws.addressing.WsaActionUtil;

import java.math.BigDecimal;
import java.util.Random;
import java.util.Scanner;

/**
 * asus 梅锦涛
 * 2021/11/12
 *
 * @author mjt
 */
public class NumberTest {

    public static void main(String[] args) {

//        Random r = new Random();
//        int i = r.nextInt(1000);
//        System.out.println(i);

        // << 左移：相当于乘2的n次方  1<<30:1乘以2的30次方
        // >> 右移：相当于除以2的n次方 8>>1: 8除以2的1次方
        int k = 8;
        System.out.println( 8 >> 1);

        int i1 = 5;
        System.out.println("i1++："+i1++); // 5
        System.out.println("i1："+i1);// 6

        int i = 1;
        int j = ++i  +  i++ + ++i + ++i + i++;
        //i值       2      3     4     5     6
        //取值      2      2     4     5     5
        System.out.println("j："+j);


    }

}

class YSFTest {

    public static void main(String[] args) {

//        int i = 10;
//        System.out.println(i >> 1 );

    /*    for (int j = 1; j < 200; j++) {
            System.out.println(Integer.toBinaryString(j));
        }
//        11111    16+8+4+2+1=31
//
//        1010111  // 87
//
//        1101111  //   64+32+15=111
//
//        1110011   //  64+32+16  112+3=115
//
//        1111011   //   115+8=123
//
//        1011000    //  64+16+8=88
//
//        1100000    //   64+32=96
//
//        1101111  //    96+15=111
//
//        1111000  // 96+24=120
//
//        10000010   //128+2=130*/

        /*// 这个是啥计算？
        int n = 0b01010001_00010001_10001111_10000110;
        int k = 0x51118f86;
        System.out.println(Integer.toBinaryString(n));
        System.out.println(Integer.toBinaryString(k));*/

        // 这个是 逻辑或（逻辑加法） 计算。会发现 n 的其中一个8位，跟m其中的一个8位合在一起，形成了k。
        // 此时k是16位的了。
      /*  int n = 0xbb;
        int m = 0x8e00;
        int k = n | m;
        System.out.println(Integer.toBinaryString(k));
*/

        // 补码
        /*for (int i = -100; i < 0; i++) {
            System.out.println(Integer.toBinaryString(i));
        }*/

        /*// 测试补码
        int j = 0b11111111111111111111111111111010;
        System.out.println(j);// -6*/

        // 二进制的逻辑与运算 &
        int n = 0x7b17242b;
        int m = 0xff;
        int k = n & m;
        System.out.println(Integer.toBinaryString(k));

    }
}

class BigDecimalTest{
    public static void main(String[] args) {

        BigDecimal num = new BigDecimal("300");
        BigDecimal str = new BigDecimal("300");
        BigDecimal divide = str.divide(num, 4, BigDecimal.ROUND_DOWN);
        BigDecimal bigDecimal = divide.multiply(new BigDecimal(100)).setScale(4, BigDecimal.ROUND_DOWN);
        System.out.println( bigDecimal);

        System.out.println("这个是测试返回的版本");

    }
}

class ArraysTest {

    public static void main(String[] args) {

        /**
         *  y = ++x 时： x先加1，再赋值给y ，此时x = 51，y = 51；
         *
         *  + x++时：y先跟x相加，因此时x和y都是51，所以 y=51+51=102；然后x再加一，x=52;
         *
         *  + --x时：x先跟自己运算，52-1=51；y再跟x相加，y = 102+51=153,x = 51;
         *
         *
         */

        int x = 50;int y = 10,z;
        z = ++x + y++ + --x; // x=51, y=153
//        y = ++x + x++ ; // x=52,y=102
//        y = ++x + 10;
//        y = ++x ;
        System.out.println(x + " , " + z + " , " + y);




    }
}
