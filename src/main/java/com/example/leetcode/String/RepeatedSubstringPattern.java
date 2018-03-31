package com.example.leetcode.String;

/**
 * <p>
 * 459. Repeated Substring Pattern
 * </p>
 *
 * @author wangdejian
 * @since 2018/3/31
 */
public class RepeatedSubstringPattern {

    /**
     * Given a non-empty string check if it can be constructed by taking a substring of it and
     * appending multiple copies of the substring together. You may assume the given string consists
     * of lowercase English letters only and its length will not exceed 10000.
     * Example 1:
     * Input: "abab"
     * <p>
     * Output: True
     * <p>
     * Explanation: It's the substring "ab" twice.
     * Example 2:
     * Input: "aba"
     * <p>
     * Output: False
     * Example 3:
     * Input: "abcabcabcabc"
     * <p>
     * Output: True
     * <p>
     * Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
     */
    public boolean repeatedSubstringPattern(String str) {
        // 重复子字符串的长度一定能被str.length()整除
        for (int i = str.length() / 2; i >= 1; i--) {
            if (str.length() % i == 0) {
                int m = str.length() / i;
                String substring = str.substring(0, i);
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < m; j++) {
                    sb.append(substring);
                }
                if (sb.toString().equals(str)) {
                    return true;
                }
            }
        }
        return false;
    }

}
