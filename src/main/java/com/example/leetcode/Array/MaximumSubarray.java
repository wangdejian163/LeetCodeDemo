package com.example.leetcode.Array;

/**
 * <p>
 * 53. 最大子序和
 * </p>
 *
 * @author wangdejian
 * @since 2018/4/15
 */
public class MaximumSubarray {
    /**
     * 给定一个序列（至少含有 1 个数），从该序列中寻找一个连续的子序列，使得子序列的和最大。
     * <p>
     * 例如，给定序列 [-2,1,-3,4,-1,2,1,-5,4]，
     * 连续子序列 [4,-1,2,1] 的和最大，为 6。
     * <p>
     * <p>
     * <p>
     * 扩展练习:
     * <p>
     * 若你已实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
     */
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum = Math.max(sum + nums[i], nums[i]);
            max = Math.max(max, sum);
        }

        return max;

    }
}
