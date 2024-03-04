package com.java.base.mathAndDataStructures;

import java.util.HashMap;
import java.util.Map;

/**
 * mjt 梅锦涛
 * 2023/2/15
 *
 * @author mjt
 */
public class ShortestSubstring {

    public String shortestSubstring(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        } // 记录 t 中每个字符出现的次数
        Map<Character, Integer> tCount = new HashMap<>();
        for (char c : t.toCharArray()) {
            tCount.put(c, tCount.getOrDefault(c, 0) + 1);
        } // 记录 s 中每个字符出现的次数
        Map<Character, Integer> sCount = new HashMap<>();
        int left = 0; // 左指针
        int right = 0; // 右指针
        int minLength = Integer.MAX_VALUE; // 记录最短的子串长度
        int start = -1; // 记录最短的子串起始位置
        // 遍历 s
        while (right < s.length()) {
            char c = s.charAt(right);
            sCount.put(c, sCount.getOrDefault(c, 0) + 1);
            // 如果 s 中包含 t 的所有字符
            if (containsAll(sCount, tCount)) { // 缩小左边界
                while (left <= right && containsAll(sCount, tCount)) {
                    char c2 = s.charAt(left);
                    sCount.put(c2, sCount.get(c2) - 1);
                    if (sCount.get(c2) == 0) {
                        sCount.remove(c2);
                    }
                    left++;
                } // 更新最短子串
                int length = right - left + 2;
                if (length < minLength) {
                    minLength = length;
                    start = left - 1;
                }
            }
            right++;
        } // 如果找到最短子串，返回该子串，否则返回空字符串
        if (start != -1) {
            return s.substring(start, start + minLength);
        } else {
            return "";
        }
    } // 判断 map1 是否包含 map2 的所有键值对

    private boolean containsAll(Map<Character, Integer> map1, Map<Character, Integer> map2) {
        for (char c : map2.keySet()) {
            if (!map1.containsKey(c) || map1.get(c) < map2.get(c)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ShortestSubstring solution = new ShortestSubstring();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(solution.shortestSubstring(s, t)); // "BANC"
    }

}
