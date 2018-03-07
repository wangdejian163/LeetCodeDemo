package com.example.leetcode.String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 *     3sum
 * </p>
 *
 * @author wangdejian
 * @since 2018/3/7
 */
public class ThreeSum {
    /**
     * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
     * Find all unique triplets in the array which gives the sum of zero.Note: The solution set must not contain duplicate triplets.
     * For example, given array S = [-1, 0, 1, 2, -1, -4],
     * A solution set is:
     * [
     * [-1, 0, 1],
     * [-1, -1, 2]
     * ]
     */
    // 题意比较好理解，找出数组中三个数相加等于零
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> list = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return list;
        }

        // 先按照有小到大排序.
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            // 最左侧的一定小于零,[0,0,0]。这一句代码测试性能提升了20%
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 定义目标变量和左右指针相加判断结果是否为零
            int target = nums[i];
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                if (nums[left] + nums[right] + target == 0) {
                    list.add(Arrays.asList(nums[left], nums[right], target));
                    // 左右指针继续移动
                    left++;
                    right--;
                    // 思路就到这不知道怎么优化，看别人写的优化跳过相同字符
                    while (left < right && nums[left] == nums[left - 1]) {
                        left--;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right++;
                    }
                } else if (nums[left] + nums[right] + target > 0) {
                    // 大于零说明最右值大于nums[left] + target
                    right--;
                } else {
                    left++;
                }
            }
        }
        return list;
    }

}
