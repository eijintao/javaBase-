package com.java.base.stream.java8LamdaOrStream.函数式思考;

import java.util.stream.LongStream;

/**
 * mjt 梅锦涛
 * 2023/5/20
 *
 * @author mjt
 */
public class JiechengTest {

    /**
     * "尾-递”的阶乘  factorialTailRecursive  factorialHelper
     * 坏消息是，目前Java还不支持这种优化
     *
     * @param n
     * @return
     */
    static long factorialTailRecursive(long n) {
        return factorialHelper(1, n);
    }
    static long factorialHelper(long acc, long n) {
        return n == 1 ? acc : factorialHelper(acc * n, n-1);
    }

    public static void main(String[] args) {




    }

}
