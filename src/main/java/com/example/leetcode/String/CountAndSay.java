package com.example.leetcode.String;

/**
 * <p>
 * 38. Count and Say
 * </p>
 *
 * @author wangdejian
 * @since 2018/3/13
 */
public class CountAndSay {
    /**
     * The count-and-say sequence is the sequence of integers with the first five terms as following:
     * 1.     1
     * 2.     11
     * 3.     21
     * 4.     1211
     * 5.     111221
     * 1 is read off as "one 1" or 11.
     * 11 is read off as "two 1s" or 21.
     * 21 is read off as "one 2, then one 1" or 1211.
     * Given an integer n, generate the nth term of the count-and-say sequence.
     * <p>
     * Note: Each term of the sequence of integers will be represented as a string.
     * <p>
     * Example 1:
     * <p>
     * Input: 1
     * Output: "1"
     * Example 2:
     * <p>
     * Input: 4
     * Output: "1211"
     * <p>
     * 上述序列中.
     * 1读取为"one 1"或11。
     * 11读取为"two 1s"或21。
     * 21读取为"one 2，然后one 1"或1211。
     * 1211读取为"one 1，然后one 2,然后 two 1s"或111221
     * 根据规律继续往下则是：312211
     */
    public static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String s = countAndSay(n - 1);
        StringBuilder sb = new StringBuilder();
        char[] c = s.toCharArray();
        int count = 0;
        for (int i = 0; i <= s.length(); i++) {
            if (i == s.length() || i - 1 >= 0 && c[i] != c[i - 1]) {
                sb.append(count);
                sb.append(c[i - 1]);
                count = 0;
            }
            count++;
        }
        return sb.toString();
    }


}
