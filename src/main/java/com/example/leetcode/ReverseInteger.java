package com.example.leetcode;

/**
 * <p>
 * </p>
 *
 * @author wangdejian
 * @since 2018/2/28
 */
public class ReverseInteger {

    /**
     * *     Given a 32-bit signed integer, reverse digits of an integer.
     * Example 1:
     * <p>
     * Input: 123
     * Output:  321
     * Example 2:
     * <p>
     * Input: -123
     * Output: -321
     * Example 3:
     * <p>
     * Input: 120
     * Output: 21
     * Note:
     * Assume we are dealing with an environment which could only hold integers
     * within the 32-bit signed integer range. For the purpose of this problem,
     * assume that your function returns 0 when the reversed integer overflows.
     * <p>
     * 这个题目比较容易理解，翻转数字，需要注意翻转后以0开头，和翻转后越界
     */
    public int reverse(int x) {
        int newInt = 0;

        while (x != 0) {
            newInt = newInt * 10 + x % 10;
            if (newInt > Integer.MAX_VALUE || newInt < Integer.MIN_VALUE) {
                return 0;
            }
            x = x / 10;
        }

        return newInt;
    }


}
