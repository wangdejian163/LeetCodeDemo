package com.example.leetcode.String;

/**
 * <p>
 * 434. 字符串中的单词数
 * </p>
 *
 * @author wangdejian
 * @since 2018/3/29
 */
public class NumberSegments {
    /**
     * 统计字符串中的单词个数，这里的单词指的是连续的非空字符。
     * <p>
     * 请注意，你可以假定字符串里不包括任何不可打印的字符。
     * <p>
     * 示例:
     * <p>
     * 输入: "Hello, my name is John"
     * 输出: 5
     *
     * 输入: "Hello, this is jim"
     * 输出: 4
     */
    public int countSegments(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int count = 0;
        int length = s.length();

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ' ' && s.charAt(i - 1) != ' ') {
                count++;
            }
        }
        if (s.charAt(s.length() - 1) != ' ') {
            count++;
        }
        return count;
    }

}
