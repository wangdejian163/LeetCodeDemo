package com.example.leetcode;

/**
 * <p>
 * <p>
 * </p>
 *
 * @author wangdejian
 * @since 2018/2/27
 */
public class StringToInteger {

    /**
     * Implement atoi to convert a string to an integer.
     * <p>
     * Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.
     * <p>
     * Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.
     * <p>
     * Requirements for atoi:
     * <p>
     * The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.
     * <p>
     * The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.
     * <p>
     * If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
     * <p>
     * If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
     * <p>
     * 百度翻译加博客说明大概了解题意：
     * 字符串转成Integer需要考虑一下几个条件：
     * 排除空字符串直到非空数字，然后找到+和-正负号开头，后面跟的数字转换为Integer,非数字直接省略。例如 +1234aa675 aa675就省略掉了。
     * 考虑Integer的边界值Integer.MAX_VALUE（2147483647），Integer.MIN_VALUE（2147483648）
     */
    public static int myAtoi(String str) {
        // 考虑字符串为空
        if (str == null || str.length() == 0) {
            return 0;
        }

        int sign = 1;// 表示正
        int i = 0; // 下标
        int base = 0;// 变量
        // 去空
        while (str.charAt(i) == ' ') {
            i++;
        }

        // 找到+、-开头
        if (str.charAt(i) == '-' || str.charAt(i) == '+') {
            sign = str.charAt(i) == '-' ? -1 : 1;
            i++;
        }

        // 判断是否为数字
        while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            // ascii码计算数字
            int digit = str.charAt(i) - '0';
            // 判断是否越界。如果base变量大于Integer.MAX_VALUE / 10，则base * 10 + digit肯定越界了。||后面的同理
            if (base > Integer.MAX_VALUE / 10 || (base == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            base = base * 10 + digit;
            i++;
        }

        return base * sign;
    }

}
