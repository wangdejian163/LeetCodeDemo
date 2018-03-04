package com.example.leetcode.String;

/**
 * <p>
 * 13. Roman to Integer
 * </p>
 *
 * @author wangdejian
 * @since 2018/3/4
 */
public class RomanToInteger {
    /**
     * Given a roman numeral, convert it to an integer.
     * nput is guaranteed to be within the range from 1 to 3999.
     * 和数字转罗马相反.
     * <p>
     * 数字、罗马数字之间的关系
     * I = 1;V = 5;X = 10;L = 50;C = 100;D = 500;M = 1000;
     * 1~9: {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
     * 10~90: {"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
     * 100~900: {"C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
     * 1000~3000: {"M", "MM", "MMM"}.
     */
    // 根据数字转罗马思路完成
    public static int romanToInt(String s) {

        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int num = 0;
        int j = 0;
        // 反过来遍历罗马数组
        for (int i = 0; i < roman.length; i++) {
            // 判断字符串中的字符和罗马数组中字符是否相等
            // CD、XC、XL、IX、IV
            while (j + 1 < s.length() && s.substring(j, j + 2).equals(roman[i])) {
                num += values[i];
                j += 2;
            }
            // M、D、C、L、X、V、I
            while (j < s.length() && s.substring(j, j + 1).equals(roman[i])) {
                num += values[i];
                j++;
                // 防止后面是CD、XC、XL、IX、IV
                continue;
            }
        }

        return num;
    }

    /**
     * 罗马数字表示法，基本字符有7个：I，V，X，L，C，D，M，分别表示1，5，10，50，100，500，1000。
     */
    public int romanToInt2(String s) {
        int sum = 0;
        // 罗马数字对应阿拉伯数字是I = 1, V = 5;下面遍历时针对I、V相加为6.而IV=4.所以需要减2.
        if (s.indexOf("IV") != -1) {
            sum -= 2;
        }
        // 同理.I = 1, X = 10 I、X相加为11, IX=9. sum -= 2
        if (s.indexOf("IX") != -1) {
            sum -= 2;
        }
        // X = 10, L = 50 X、L相加为60. XL = 40.
        if (s.indexOf("XL") != -1) {
            sum -= 20;
        }
        // ...
        if (s.indexOf("XC") != -1) {
            sum -= 20;
        }
        if (s.indexOf("CD") != -1) {
            sum -= 200;
        }
        if (s.indexOf("CM") != -1) {
            sum -= 200L;
        }

        char[] c = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (c[i] == 'I') {
                sum += 1;
            }
            if (c[i] == 'V') {
                sum += 5;
            }
            if (c[i] == 'X') {
                sum += 10;
            }
            if (c[i] == 'L') {
                sum += 50;
            }
            if (c[i] == 'C') {
                sum += 100;
            }
            if (c[i] == 'D') {
                sum += 500;
            }
            if (c[i] == 'M') {
                sum += 1000;
            }
        }
        return sum;
    }

}
