package com.example.leetcode.String;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <p>
 * 49. Group Anagrams
 * </p>
 *
 * @author wangdejian
 * @since 2018/3/15
 */
public class GroupAnagrams {
    /**
     * Given an array of strings, group anagrams together.
     * For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
     * Return:
     * [
     * ["ate", "eat","tea"],
     * ["nat","tan"],
     * ["bat"]
     * ]
     * Note: All inputs will be in lower-case.
     * 将给定字符串分组，要求同一组的字符串由相同字符组成，最终，将各组字符串按字典序输出，所有输入均为小写。
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length < 1) {
            return new ArrayList<>();
        }

        // java8。按照什么什么分组
        Map<String, List<String>> collectMap = Arrays.stream(strs).collect(Collectors.groupingBy((str) -> {
            char[] chars = str.toCharArray();
            // 按照字典顺序排序
            Arrays.sort(chars);
            return new String(chars);
        }));

        Stream<List<String>> stream = collectMap.values().stream();
        return stream.collect(Collectors.toList());
    }

}
