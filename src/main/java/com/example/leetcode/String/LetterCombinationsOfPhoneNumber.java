package com.example.leetcode.String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>
 * 17. Letter Combinations of a Phone Number
 * </p>
 *
 * @author wangdejian
 * @since 2018/3/8
 */
public class LetterCombinationsOfPhoneNumber {
    /**
     * Given a digit string, return all possible letter combinations that the number could represent.
     * A mapping of digit to letters (just like on the telephone buttons) is given below.
     * Input:Digit string "23"
     * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
     * <p>
     * 给定一个数字字符串，返回所有数字对应字母组合，对应关系参照电话按钮上
     * <p>
     * 例如给定 "23"
     * 返回 ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
     * 注意：
     * 尽管上面的答案是按字典顺序排列的，但您的答案可以按您想要的任何顺序排列。
     * num = {'2','3','4','5','6','7','8','9'};
     * letter = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
     */

    /**
     * 回溯是 DFS 的一种，它不是用在遍历图的节点上，而是用于求解 排列组合 问题，例如有 { 'a','b','c' } 三个字符，求解所有由这三个字符排列得到的字符串。
     * 在程序实现时，回溯需要注意对元素进行标记的问题。使用递归实现的回溯，在访问一个新元素进入新的递归调用，此时需要将新元素标记为已经访问，
     * 这样才能在继续递归调用时不用重复访问该元素；但是在递归返回时，需要将该元素标记为未访问，因为只需要保证在一个递归链中不同时访问一个元素，
     * 而在不同的递归链是可以访问已经访问过但是不在当前递归链中的元素。
     *
     * @param digits
     * @return
     */
    private static final String[] KEYS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> list = new LinkedList<String>();
        if (digits != null && digits.length() != 0) {
            String prefix = "";
            recursionBacking(prefix, digits, 0, list);
        }
        return list;
    }

    private void recursionBacking(String prefix, String digits, int offset, List<String> list) {
        if (offset == digits.length()) {
            list.add(prefix);
            return;
        }

        String str = KEYS[digits.charAt(offset) - '0'];
        for (int i = 0; i < str.length(); i++) {
            recursionBacking(prefix + str.charAt(i), digits, offset + 1, list);
        }

    }

}
