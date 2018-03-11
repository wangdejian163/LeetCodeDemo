package com.example.leetcode.String;

/**
 * <p>
 * 28. Implement strStr()
 * </p>
 *
 * @author wangdejian
 * @since 2018/3/11
 */
public class ImplementStrStr {

    /**
     * Implement strStr().
     * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
     * Example 1:
     * Input: haystack = "hello", needle = "ll"
     * Output: 2
     * Example 2:
     * Input: haystack = "aaaaa", needle = "bba"
     * Output: -1
     */
    // 判断一个字符串needle是否是另一个字符串haystack的子串, 在一个字符串haystack中找另一个字符串needle第一次出现的位置.
    // 使用api最简单 haystack.indexOf(needle);
    public static int strStr(String haystack, String needle) {

        if (needle.length() < 1) {
            return 0;
        }
        if (needle.length() > haystack.length()) {
            return -1;
        }

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.substring(i, i + needle.length()).equals(needle)) {
                return i;
            }
        }
        return -1;
    }

}
