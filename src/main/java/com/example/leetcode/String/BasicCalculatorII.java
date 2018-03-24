package com.example.leetcode.String;

/**
 * <p>
 * 227  Basic Calculator II
 * </p>
 *
 * @author wangdejian
 * @since 2018/3/24
 */
public class BasicCalculatorII {

    /**
     * Implement a basic calculator to evaluate a simple expression string.
     * <p>
     * The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.
     * <p>
     * You may assume that the given expression is always valid.
     * <p>
     * Some examples:
     * "3+2*2" = 7
     * " 3/2 " = 1
     * " 3+5 / 2 " = 5
     * Note: Do not use the eval built-in library function.
     * 实现一个基本的计算器来评估简单的表达式字符串,表达字符串只包含非负整数，+，-，*，/运营商和空的空间 。整数除法除不尽省略
     */
    public int calculate(String s) {
        if (s == null) return 0;
        s = s.trim().replaceAll(" +", "");
        int length = s.length();

        int res = 0;
        long preVal = 0; // initial preVal is 0
        char sign = '+'; // initial sign is +
        int i = 0;
        while (i < length) {
            long curVal = 0;
            while (i < length && (int) s.charAt(i) <= 57 && (int) s.charAt(i) >= 48) { // int
                curVal = curVal * 10 + (s.charAt(i) - '0');
                i++;
            }
            if (sign == '+') {
                res += preVal;  // update res
                preVal = curVal;
            } else if (sign == '-') {
                res += preVal;  // update res
                preVal = -curVal;
            } else if (sign == '*') {
                preVal = preVal * curVal; // not update res, combine preVal & curVal and keep loop
            } else if (sign == '/') {
                preVal = preVal / curVal; // not update res, combine preVal & curVal and keep loop
            }
            if (i < length) { // getting new sign
                sign = s.charAt(i);
                i++;
            }
        }
        res += preVal;
        return res;
    }
}
