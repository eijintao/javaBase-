package com.java.base.arithmetic.stack;

/**
 * mjt 梅锦涛
 * 2024/3/7
 *
 * @author mjt
 */
public class Solution {

    public boolean isValid(String s) {
        if (s.length()%2==1)return false;
        int length = s.length()/2;
        for (int i = 0; i < length; i++) {
            s=s.replace("()", "").replace("{}", "").replace("[]", "");
        }
        if (s.length()==0)return true;
        else return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isValid("{[]}"));
    }
}
