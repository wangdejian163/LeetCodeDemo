package com.example.leetcode.String;

/**
 * <p>
 * 520. 检测大写字母
 * </p>
 *
 * @author wangdejian
 * @since 2018/4/2
 */
public class DetectCapital {
    /**
     * 给定一个单词，你需要判断单词的大写使用是否正确。
     * <p>
     * 我们定义，在以下情况时，单词的大写用法是正确的：
     * <p>
     * 全部字母都是大写，比如"USA"。
     * 单词中所有字母都不是大写，比如"leetcode"。
     * 如果单词不只含有一个字母，只有首字母大写， 比如 "Google"。
     * 否则，我们定义这个单词没有正确使用大写字母。
     * <p>
     * 示例 1:
     * <p>
     * 输入: "USA"
     * 输出: True
     * 示例 2:
     * <p>
     * 输入: "FlaG"
     * 输出: False
     * 注意: 输入是由大写和小写拉丁字母组成的非空单词。
     */
    public boolean detectCapitalUse(String word) {
        // 判断是否是全部大写.
        if (word.toUpperCase().equals(word)) {
            return true;
        }

        char[] chars = word.toCharArray();
        // 第一个字母大小写无所谓
        for (int i = 1; i < chars.length; i++) {
            // 从第二个字母开始判断如果是大写就返回false.
            if (chars[i] - 'A' >= 0 && chars[i] - 'A' <= 26) {
                return false;
            }
        }
        return true;
    }
}
