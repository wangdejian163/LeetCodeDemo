package com.example.leetcode.String;

/**
 * <p>
 * 43. Multiply Strings
 * </p>
 *
 * @author wangdejian
 * @since 2018/3/14
 */
public class MultiplyStrings {

    /**
     * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2.
     * Note:
     * The length of both num1 and num2 is < 110.
     * Both num1 and num2 contains only digits 0-9.
     * Both num1 and num2 does not contain any leading zero.
     * You must not use any built-in BigInteger library or convert the inputs to integer directly.
     * <p>
     * 题目大概意思是两个字符串表示的非负整数相乘，用字符串的形式返回积。字符串不会有0开头，字符串只有0-9的数字。不用使用BigInteger
     */

    public String multiply(String num1, String num2) {

        // 两个数相乘，位数不会大于其和
        int[] products = new int[num1.length() + num2.length()];
        // 遍历两个字符串.将乘积存放到数组中
        for (int n1 = num1.length() - 1; n1 >= 0; n1--) {
            for (int n2 = num2.length() - 1; n2 >= 0; n2--) {
                int v1 = num1.charAt(n1) - '0';
                int v2 = num2.charAt(n2) - '0';
                // 将乘积结果存放到对应的下标下。 下标相加值相同。累加结果.
                products[n1 + n2 + 1] += v1 * v2;
            }
        }

        int carry = 0;
        for (int i = products.length - 1; i >= 0; i--) {
            int tmp = (products[i] + carry) % 10;
            carry = (products[i] + carry) / 10;
            products[i] = tmp;
        }

        StringBuilder sb = new StringBuilder();
        for (int num : products) {
            sb.append(num);
        }
        while (sb.length() != 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
