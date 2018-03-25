package com.example.leetcode.String;

/**
 * <p>
 * 344 Reverse String
 * 从今天开始有中文版leetcode网站了,中文还是各种bug，目前不如原版好用
 * </p>
 *
 * @author wangdejian
 * @since 2018/3/25
 */
public class ReverseString {
    /**
     * 请编写一个函数，其功能是将输入的字符串反转过来。
     * <p>
     * 示例：
     * <p>
     * 输入：s = "hello"
     * 返回："olleh"
     */
    public String reverseString(String s) {

        if (s == null || s.length() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    /**
     * 替换头指针和尾指针.
     *
     * @param s
     * @return
     */
    public String reverseString2(String s) {
        char[] words = s.toCharArray();
        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            char temp = words[start];
            words[start] = words[end];
            words[end] = temp;

            ++start;
            --end;
        }

        return new String(words);
    }
}
