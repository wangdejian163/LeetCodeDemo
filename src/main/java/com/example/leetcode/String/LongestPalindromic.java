package com.example.leetcode.String;

/**
 * <p>
 * 找出最大的回文字符串。首先需要理解什么是回文字符串，正读反读都一样的字符串就是回文字符串。
 * </p>
 *
 * @author wangdejian
 * @since 2018/3/2
 */
public class LongestPalindromic {
    /**
     * Given a string s, find the longest palindromic substring in s.
     * You may assume that the maximum length of s is 1000.
     * Example:
     * Input: "babad"
     * Output: "bab"
     * Note: "aba" is also a valid answer.
     * Example:
     * Input: "cbbd"
     * Output: "bb"
     */
    // 这种挨个遍历查询会超时. 如果参数s = zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz............
    public String longestPalindrome(String s) {
        int maxLength = 0;
        int maxStart = 0;
        if (s.length() <= 1) {
            return s;
        }
        //i是字符串长度
        for (int i = 0; i < s.length(); i++) {
            //j是字符串起始位置
            for (int j = 0; j < s.length() - i; j++) {
                //挨个判断是否回文
                if (isPalindrome(s, i, j)) {
                    maxLength = i + 1;
                    maxStart = j;
                }
            }
        }
        return s.substring(maxStart, maxStart + maxLength);
    }

    private boolean isPalindrome(String s, int i, int j) {
        int left = j;
        int right = j + i;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // **********************************************************网上大神写的比较受赞同的有两种**************
    // 中心扩展法.遍历字符串的每一个字符，如果存在回文子串，那么中心是某一个字符（奇数）或两个字符的空隙（偶数），
    // 然后分两种情况（奇数或偶数）向两边扩展。
    private int lo, maxLen;
    public String longestPalindrome2(String s) {
        // 一个字符本身就是回文串
        if (s.length() <= 1) {
            return s;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            extendPalindrome(s, i, i); // 回文子串是奇数的情况.例如：level
            extendPalindrome(s, i, i + 1); // 回文子串是偶数的情况 leel
        }
        return s.substring(lo, lo + maxLen);
    }

    private void extendPalindrome(String s, int j, int k) {
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }
        if (maxLen < k -j -1) {
            maxLen = k -j - 1;
            lo = j + 1;
        }
    }

    // 动态规划法




}
