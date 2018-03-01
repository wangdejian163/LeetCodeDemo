package com.example.leetcode.String;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>
 *
 * </p>
 *
 * @author wangdejian
 * @since 2018/3/1
 */
public class LongestSubString {
    /**
     * Given a string, find the length of the longest substring without repeating characters.

     Examples:

     Given "abcabcbb", the answer is "abc", which the length is 3.

     Given "bbbbb", the answer is "b", with the length of 1.

     Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring,
     "pwke" is a subsequence and not a substring.
     */
    // 题意的大概意思是计算出没有重复字符的最大长度。
    public static  int lengthOfLongestSubstring(String s) {
        if (s == "" || s == null) {
            return 0;
        }

        /**
         * 刚开始想了也是用set来操作，没想出来怎么实现。看到别人写的结果特别赞。
         * 思路是需要两个指针，使用快速指针i判断s.charAt(i)是否在集合set中已经存在，如果不存在则添加到集合中去，向前移动指针并更新最大长度，
         * 否则当出现重复字符时，使用指针j从头部开始移除，直到可以把字符放到集合中。继续移动指针i。
         */
        Set<Character> set = new HashSet();
        int i = 0, j = 0, max = 0;
        while (i < s.length()) {
            if (!set.contains(s.charAt(i))) {
                set.add(s.charAt(i));
                i++;
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(j));
                j++;
            }
        }
     return max;
    }

}
