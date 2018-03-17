package com.example.leetcode.String;

/**
 * <p>
 * 67. Add Binary
 * </p>
 *
 * @author wangdejian
 * @since 2018/3/17
 */
public class AddBinary {

    /**
     * Given two binary strings, return their sum (also a binary string).
     * For example,
     * a = "11"
     * b = "1"
     *
     * Return "100".
     * 两个二进制字符串相加
     */

    /**
     * 上述例子:二进制相加，高位补零
     * 11
     * +  01
     * 1_1_______
     * 1 0 0
     */
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        // 定义进位标志符
        int carry = 0;
        // 二进制相加，从低位相加.
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j--;
            }

            if (i >= 0) {
                sum += a.charAt(i) - '0';
                i--;
            }
            // 由低位开始相加，逢二进一。
            sb.append(sum % 2);
            carry = sum / 2;

        }

        if (carry != 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

}
