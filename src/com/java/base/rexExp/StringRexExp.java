package com.java.base.rexExp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * asus 梅锦涛
 * 2022/9/3
 *
 * @author mjt
 */
public class StringRexExp {

    /**
     * 正则表达式：
     *      匹配符：
     *            1:java正则表达式默认是区分大小写，如何实现不区分大小写？
     *                  (?i)abc: 表示abc都不区分大小写
     *                  a(?i)bc: 表示bc不区分大小写
     *                  a((?i)b)c: 表示b不区分大小写
     *                  Pattern.compile(regEx,Pattern.CASE_INSENSITIVE)：表示该regEx不区分大小写
     *            2: \w : 匹配字母、数字、下划线。等价于 [A-Za-z0-9_] 。  \W取反 等价于 [^A-Za-z0-9_]
     *               \d ：匹配数字，等价于[0-9] 。  \D取反 等价于 [^0-9]
     *               \s : 匹配任何空白字符 。 \S取反
     *
     *
     *
     *
     *
     *
     * @param args
     */

    public static void main(String[] args) {
        String str = "a11c8";
        Pattern pattern = Pattern.compile("[^a-z]{2}",Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            int count = 0;
            System.out.println("找到第" + ++count + "个，内容是：" + matcher.group(0));
        }

    }

}

/**
 * 限定符的匹配
 *      java匹配规则：
 *          默认是 贪婪匹配：即尽可能的匹配更多的。
 *               String regStr = "a{3,4}"; // 匹配aaaa  ，不是先匹配3个。
 */
class StringRexExpTest {
    public static void main(String[] args) {
        String content = "1111111aaaahello";
        // a{3} 1{4} \d{2}
        //String regStr = "a{3}"; // 表示匹配aaa
        //String regStr = "1{4}"; // 表示匹配1111
        //String regStr = "\\d{2}"; // 表示匹配任意两位数字字符

        //默认是 贪婪匹配：即尽可能的匹配更多的。
        String regStr = "a{3,4}"; // 匹配aaaa

        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            int count = 0;
            System.out.println("找到第" + ++count + "个，内容是：" + matcher.group(0));
        }


    }
}


class StringRexExpYinHao {

    public static void main(String[] args) {
        String input = "alter table zhrx_456.TMP_TN_SYS_MENU_FAVORITES add if not exists  partition ( `date`=${optime});";
        String pattern = "`([^`]+)`"; // 正则表达式，匹配两侧带有反引号的内容

        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(input);

        while (matcher.find()) {
            String match = matcher.group(1); // 获取第一个捕获组的内容
            System.out.println("Match: " + match);
        }





    }


}
