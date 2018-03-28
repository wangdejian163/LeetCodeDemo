package com.example.leetcode.String;

/**
 * <p>
 * 345. 反转字符串中的元音字母
 * </p>
 *
 * @author wangdejian
 * @since 2018/3/26
 */
public class ReverseVowelsOfString {
    /**
     * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
     * <p>
     * 示例 1：
     * 给定 s = "hello", 返回 "holle".
     * <p>
     * 示例 2：
     * 给定 s = "leetcode", 返回 "leotcede".
     * <p>
     * 注意:
     * 元音字母不包括 "y".
     */
    // 元音字母就五个:a,e,i,o,u
    public String reverseVowels(String s) {

        if (s == null || s.length() == 0) {
            return "";
        }
        char[] chars = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;
        StringBuilder sb = new StringBuilder(s.length());
        while (left < s.length() || right >= 0) {
            // 移动左指针,指导元音字母时停止
            while (left < s.length() && !isVowel(chars[left])) {
                sb.append(chars[left++]);
            }
            // 移动右指针，直到元音字母时停止
            while (right >= 0 && !isVowel(chars[right])) {
                right--;
            }
            if (right >= 0) {
                sb.append(chars[right]);
            }
            left++;
            right--;

        }

        return sb.toString();
    }

    private boolean isVowel(char c) {
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }


    public static String reverseVowels2(String s) {
        int l = 0;
        int r = s.length() - 1;
        char[] value = s.toCharArray();
        while (l < r) {
            while (!isVowels2(value[l]) && l < r) {
                l++;
            }
            while (!isVowels2(value[r]) && l < r) {
                r--;
            }
            if (l < r) {
                char temp = value[l];
                value[l] = value[r];
                value[r] = temp;
                l++;
                r--;
            }
        }
        return new String(value);
    }


    public static boolean isVowels2(char c) {
        char[] vowels = new char[]{'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        for (int i = 0; i < vowels.length; i++) {
            if (c == vowels[i]) {
                return true;
            }
        }
        return false;
    }

}
