package com.example.leetcode.String;

/**
 * <p>
 * 12. Integer to Roman
 * </p>
 *
 * @author wangdejian
 * @since 2018/3/4
 */
public class IntegerToRoman {
    /**
     * Given an integer, convert it to a roman numeral.
     * Input is guaranteed to be within the range from 1 to 3999.
     * 给定一个数字，转成罗马数字。
     * I = 1;V = 5;X = 10;L = 50;C = 100;D = 500;M = 1000;
     * 1~9: {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
     * 10~90: {"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
     * 100~900: {"C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
     * 1000~3000: {"M", "MM", "MMM"}.
     */
    // 看到一个点赞第一个答案，真的是思路牛，简单明了。短短五行代码搞定
    public String intToRoman(int num) {
        if (num < 1 || num > 3999) {
            return "";
        }

        String[] M = {"", "M", "MM", "MMM"}; // 千
        String[] C = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"}; // 百
        String[] X = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"}; // 十
        String[] I = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"}; // 个
        // 然后拼接即可
        return M[num / 1000] + C[num % 100] + X[num / 10] + I[num % 10];
    }

    /**
     * 两种方式都巧妙的运行了数字和罗马数字之前的关系.
     *
     * @param num
     * @return
     */
    public static String intToRoman2(int num) {
        if (num < 1 || num > 3999) {
            return "";
        }

        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            while (num >= values[i]) {
                num -= values[i];
                sb.append(roman[i]);
            }
            i++;
        }
        return sb.toString();
    }

}