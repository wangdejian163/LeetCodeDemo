package com.example.leetcode.String;

/**
 * <p>
 * 58. Length of Last Word
 * </p>
 *
 * @author wangdejian
 * @since 2018/3/16
 */
public class LengthOfLastWord {

    /**
     * Given a string s consists of upper/lower-case alphabets and empty space characters ' ',
     * return the length of last word in the string.If the last word does not exist, return 0.
     * Note: A word is defined as a character sequence consists of non-space characters only.
     * Example:
     * Input: "Hello World
     * Output: 5
     * <p>
     * 给定一个字符串s由大写/小写字母和空白字符组成' '，返回字符串中最后一个单词的长度。
     * 如果最后一个字不存在，则返回0。
     * 注意：单词被定义为只包含非空格字符的字符序列。
     */
    public int lengthOfLastWord(String s) {

        if (s == null || s.length() < 1) {
            return 0;
        }

        // 如果包含空格
        if (s.indexOf(" ") != -1) {
            String[] split = s.split(" ");
            // 判断是否全部是空格组成,如果最后一个字不存在，则返回0
            return split.length == 0 ? 0 : split[split.length - 1].length();
        } else {
            // 否则直接返回
            return s.length();
        }
    }

    // 要多思考一下怎么实现才是更好的解决办法。下面的方式要比我写的快2ms。
    public int lengthOfLastWord2(String s) {
        // 减少时间复杂度，直接从最后一个字符开始判断
        int len = s.length(), lastLength = 0;
        while (len > 0 && s.charAt(len - 1) == ' ') {
            len--;
        }

        while (len > 0 && s.charAt(len - 1) != ' ') {
            lastLength++;
            len--;
        }

        return lastLength;
    }

}
