package com.example.leetcode.String;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 151. Reverse Words in a String
 * </p>
 *
 * @author wangdejian
 * @since 2018/3/22
 */
public class ReverseWordsInAString {
    /**
     * Given an input string, reverse the string word by word.
     * <p>
     * For example,
     * Given s = "the sky is blue",
     * return "blue is sky the".
     * <p>
     * 翻转字符串中的单词，如果单词之间遇到多个空格，只能返回一个，而且首尾不能有单词.
     */
    // 5ms
    public String reverseWords(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }

        // 先按照空格分割开单词.
        String[] strArr = s.split(" ");
        List<String> list = new ArrayList<>();
        // 遍历分隔开的单词，这些单词中可能会包含空格.
        for (int i = 0; i < strArr.length; i++) {
            // 排除掉空格.添加到集合中
            if (strArr[i].length() > 0) {
                list.add(strArr[i]);
            }
        }

        StringBuilder sb = new StringBuilder();
        // 再从集合末尾开始取单词存放到StringBuilder.
        for (int i = list.size() - 1; i >= 0; i--) {
            sb.append(list.get(i) + " ");

        }
        return sb.toString().trim();
    }

    // 排名靠前的2ms执行完毕的大神，省略了往list中存的步骤，直接在第一次循环的时候就从末尾开始判断。
    public String reverseWords2(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        // split to words by space
        String[] arr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; --i) {
            if (!arr[i].equals("")) {
                sb.append(arr[i]).append(" ");
            }
        }
        return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1);
    }

}
