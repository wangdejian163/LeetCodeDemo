package com.example.leetcode.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 39. 组合总和
 * </p>
 *
 * @author wangdejian
 * @since 2018/4/14
 */
public class CombinationSum {
    /**
     * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
     * <p>
     * candidates 中的数字可以无限制重复被选取。
     * <p>
     * 说明：
     * <p>
     * 所有数字（包括 target）都是正整数。
     * 解集不能包含重复的组合。
     * 示例 1:
     * <p>
     * 输入: candidates = [2,3,6,7], target = 7,
     * 所求解集为:
     * [
     * [7],
     * [2,2,3]
     * ]
     * 示例 2:
     * <p>
     * 输入: candidates = [2,3,5], target = 8,
     * 所求解集为:
     * [
     * [2,2,2,2],
     * [2,3,3],
     * [3,5]
     * ]
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> lists = new ArrayList<>();
        addList(lists, new ArrayList<>(), candidates, target, 0);
        return lists;
    }

    private void addList(List<List<Integer>> lists, List<Integer> list, int[] candidates, int target, int i) {
        if (candidates.length == i || candidates[i] > target) {
            if (list.size() > 0 && target == 0) {
                lists.add(list);
            }
            return;
        }
        for (int j = 0; j < target / candidates[i]; j++) {
            if (j == 0) {
                addList(lists, new ArrayList<>(list), candidates, target, i + 1);
            }
            list.add(candidates[i]);
            addList(lists, new ArrayList<>(list), candidates, target - candidates[i] * (j + 1), i + 1);
        }
    }
}
