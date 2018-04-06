package com.example.leetcode.Array;

import java.util.Arrays;

/**
 * <p>
 * 最接近的三数之和
 * </p>
 *
 * @author wangdejian
 * @since 2018/4/6
 */
public class ThreeSumClosest {
    /**
     * 给定一个包括 n 个整数的数组 S，找出 S 中的三个整数使得他们的和与给定的数 target 最接近。返回这三个数的和。假定每组输入只存在一个答案。
     * <p>
     * 例如，给定数组 S = {-1 2 1 -4}, 并且 target = 1.
     * <p>
     * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
     */
    public static int threeSumClosest(int[] nums, int target) {
        // 使用三个指针指向当前元素，下一个元素和最后一个元素
        int result = nums[0] + nums[1] + nums[nums.length - 1];
        Arrays.sort(nums);
        // 如果总和小于目标值，则需要继续往右移动添加更大的元素；如果总和大于目标值，则向左以移动指针.
        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int it = nums[i] + nums[start] + nums[end];
                if (it > target) {
                    end--;
                } else {
                    start++;
                }
                if (Math.abs(it - target) < Math.abs(result - target)) {
                    result = it;
                }
            }

        }
        return result;
    }

}
