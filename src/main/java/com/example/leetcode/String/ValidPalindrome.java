package com.example.leetcode.String;

/**
 * <p>
 * 125. Valid Palindrome
 * </p>
 *
 * @author wangdejian
 * @since 2018/3/21
 */
public class ValidPalindrome {
    /**
     * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
     * <p>
     * For example,
     * "A man, a plan, a canal: Panama" is a palindrome.
     * "race a car" is not a palindrome.
     * <p>
     * Note:
     * Have you consider that the string might be empty? This is a good question to ask during an interview.
     * <p>
     * For the purpose of this problem, we define empty string as valid palindrome.
     */
    // 判断字符串是否是回文字符串,忽略掉空格和特殊字符.
    public boolean isPalindrome(String s) {
        if (s.isEmpty()) {
            return true;
        }
        int head = 0, tail = s.length() - 1;
        char cHead, cTail;
        while (head <= tail) {
            cHead = s.charAt(head);
            cTail = s.charAt(tail);
            // 判断指定的 Unicode 字符是否属于字母或十进制数字
            if (!Character.isLetterOrDigit(cHead)) {
                head++;
            } else if (!Character.isLetterOrDigit(cTail)) {
                tail--;
            } else {
                if (Character.toLowerCase(cHead) != Character.toLowerCase(cTail)) {
                    return false;
                }
                head++;
                tail--;
            }
        }

        return true;
    }

    public boolean isPalindrome2(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            // 如果不是字母或数字说明就是特殊字符，直接跳过.
            while (i < s.length() && !isValid(s.charAt(i))) {
                i++;
            }
            while (j >= 0 && !isValid(s.charAt(j))) {
                j--;
            }
            if (i < j && Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    private boolean isValid(char c) {
        return (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z');
    }
}
