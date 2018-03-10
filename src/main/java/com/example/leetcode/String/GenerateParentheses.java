package com.example.leetcode.String;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>
 * 22. Generate Parentheses
 * </p>
 *
 * @author wangdejian
 * @since 2018/3/10
 */
public class GenerateParentheses {

    /**
     * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
     * For example, given n = 3, a solution set is:
     * [
     * "((()))",
     * "(()())",
     * "(())()",
     * "()(())",
     * "()()()"
     * ]
     */

    // DFS递归算法.

    /**
     * 看网上的说明：Backtracking的思路是当前有若干选择，尝试每一种选择。如果已经发现某一种选择不符合条件(违反某些限定条件),
     * 就返回；如果某种选择是正解，就将其加入结果集中.
     * 思考递归需要考虑三个点：选择、限制、结束条件
     * 本题中存在的选择:
     * 1.选择左括号,2.选择右括号
     * <p>
     * 限制:
     * 1.不能右括号开头..左右括号一样多时，不能再继续添加左括号，否则一定无法匹配。
     * 2.如果左括号用完，不能继续添加左括号；
     * 结束条件
     * 左右括号都用完
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        dfs(list, "", n, n);
        return list;
    }

    private void dfs(List<String> list, String s, int left, int right) {

        if (left > right) {
            return;
        }
        if (left == 0 && right == 0) {
            list.add(s);
            return;
        }

        if (left > 0) {
            dfs(list, s + '(', left - 1, right);
        }
        if (right > 0) {
            dfs(list, s + ')', left, right - 1);
        }
    }

}
