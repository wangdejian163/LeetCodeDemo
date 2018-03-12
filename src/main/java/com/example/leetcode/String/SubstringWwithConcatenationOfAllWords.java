package com.example.leetcode.String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 30.Substring with Concatenation of All Words
 * </p>
 *
 * @author wangdejian
 * @since 2018/3/12
 */
public class SubstringWwithConcatenationOfAllWords {

    /**
     * You are given a string, s, and a list of words, words, that are all of the same length.
     * Find all starting indices of substring(s) in s that is a concatenation of each word in words
     * exactly once and without any intervening characters.
     * For example, given:
     * s: "barfoothefoobarman"
     * words: ["foo", "bar"]
     * You should return the indices: [0,9].
     * (order does not matter).
     * <p>
     * // words: ["foo", "bar"] s: "barfoothefoobarman".其中 barfoo符合要求，起始索引0，foobar也符合要求，起始索引9
     */

    // 给定一个字符串s，和一个words数组；字符串数组中的字符串长度都是一样的。
    // 找出s中所有的子串，要求这些子串是字符串数组中的所有字符串拼接的结果，字符串拼接的时候顺序可以随意。最终返回子串开始的位置。
    public List<Integer> findSubstring(String s, String[] words) {
        final Map<String, Integer> counts = new HashMap<>();
        // 把数组中的单词放到map中，如果单词相同，value值1.
        for (final String word : words) {
            counts.put(word, counts.getOrDefault(word, 0) + 1);
        }
        final List<Integer> indexes = new ArrayList<>();
        final int n = s.length(), num = words.length, len = words[0].length();
        for (int i = 0; i < n - num * len + 1; i++) {
            final Map<String, Integer> seen = new HashMap<>();
            int j = 0;
            while (j < num) {
                final String word = s.substring(i + j * len, i + (j + 1) * len);
                if (counts.containsKey(word)) {
                    seen.put(word, seen.getOrDefault(word, 0) + 1);
                    if (seen.get(word) > counts.getOrDefault(word, 0)) {
                        break;
                    }
                } else {
                    break;
                }
                j++;
            }
            if (j == num) {
                indexes.add(i);
            }
        }
        return indexes;
    }
}
