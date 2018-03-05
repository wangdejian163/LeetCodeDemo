package com.example.leetcode.String;

/**
 * <p></p>
 *
 * @author wangdejian
 * @since 2018/3/5
 */
public class LongestCommonPrefix {

    /**
     * Write a function to find the longest common prefix string amongst an array of strings.
     * 查找字符串数组中最长的公共前缀字符串.
     * 例如：
     * "abcdefg"
     * "abcdefghijk"
     * "abcdfghijk"
     * "abcef"
     * 上面的字符串数组的最长公共前缀就是"abc"。
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        // 先假设第一个为最短数
        String shortest = strs[0];
        // 循环遍历数组找出真正的最短字符串
        for (int i = 1; i < strs.length; i++) {
            if (shortest.length() > strs[i].length()) {
                shortest = strs[i];
            }
        }

        // 判断该最短数是否是公共的前缀.
        for (int i = 0; i < strs.length; i++) {
            while (strs[i].indexOf(shortest) != 0) {
                shortest = shortest.substring(0, shortest.length() - 1);
            }
        }

        return shortest;
    }

    /**
     * 下面这个leetcode上大神写的跟我想的思路差不多。不过简洁了很多很多很多...
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        // 也是先假定一个比较数就是公共前缀，不同的是并没有通过循环比较出最短数字，而是直接判断prefix是否是数组的公共前缀。
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }

        return prefix;
    }
}
