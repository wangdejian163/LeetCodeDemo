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

}
