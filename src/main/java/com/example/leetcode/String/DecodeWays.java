package com.example.leetcode.String;

/**
 * <p>
 * 91. Decode Ways
 * </p>
 *
 * @author wangdejian
 * @since 2018/3/19
 */
public class DecodeWays {

    /**
     * A message containing letters from A-Z is being encoded to numbers using the following mapping:
     * 'A' -> 1
     * 'B' -> 2
     * ...
     * 'Z' -> 26
     * Given an encoded message containing digits, determine the total number of ways to decode it.
     * <p>
     * For example,
     * Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
     * <p>
     * The number of ways decoding "12" is 2.
     * 包含字母的消息A-Z,和数字具有映射关系。求一个编码消息字符串对应几种字母组合.
     */

    public int numDecodings(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        // 采用动态归纳方法，使用n + 1 保存子串，dp[0]意味着一个空字符串有一种解码方式，dp[1]意味着解码一个大小为1的字符串的方式。
        // 检查一个数字和两个数字的组合，并沿途保存结果。最终dp[n]为最终结果.
        for(int i = 2; i <= n; i++) {
            int first = Integer.valueOf(s.substring(i-1, i));
            int second = Integer.valueOf(s.substring(i-2, i));
            if(first >= 1 && first <= 9) {
                dp[i] += dp[i-1];
            }
            if(second >= 10 && second <= 26) {
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }
}