package com.example.leetcode.String;

/**
 * <p>
 * 383. 赎金信
 * </p>
 *
 * @author wangdejian
 * @since 2018/3/27
 */
public class RansomNote {
    /**
     * 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串ransom能不能由第二个字符串magazines里面的字符构成。
     * 如果可以构成，返回 true ；否则返回 false。
     * <p>
     * (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。)
     * <p>
     * 注意：
     * <p>
     * 你可以假设两个字符串均只含有小写字母。
     * <p>
     * canConstruct("a", "b") -> false
     * canConstruct("aa", "ab") -> false
     * canConstruct("aa", "aab") -> true
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        int [] arr = new int[26];
        char[] chars = magazine.toCharArray();
        char[] chars1 = ransomNote.toCharArray();
        for (int i = 0; i <chars.length; i++) {
           arr[chars[i] - 'a']++;
       }
       for (int i = 0; i < chars1.length; i++) {
            if (-arr[(chars1[i] - 'a')] == -1) {
                return false;
            }
       }
       return true;
    }
}
