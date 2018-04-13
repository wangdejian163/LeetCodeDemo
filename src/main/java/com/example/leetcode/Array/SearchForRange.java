package com.example.leetcode.Array;

/**
 * <p>
 * 34. 搜索范围
 * </p>
 *
 * @author wangdejian
 * @since 2018/4/13
 */
public class SearchForRange {
    /**
     * 给定一个已经升序排序的整形数组，找出给定目标值的开始位置和结束位置。
     * <p>
     * 你的算法时间复杂度必须是 O(log n) 级别。
     * <p>
     * 如果在数组中找不到目标，返回 [-1, -1]。
     * <p>
     * 例如:
     * 给出 [5, 7, 7, 8, 8, 10] 和目标值 8，
     * 返回 [3, 4]。
     */
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        if (nums == null || nums.length == 0) {
            return res;
        }
        int ll = 0;
        int lr = nums.length - 1;
        while (ll <= lr) {
            int m = (ll + lr) / 2;
            if (nums[m] < target) {
                ll = m + 1;
            } else {
                lr = m - 1;
            }
        }
        int rl = 0;
        int rr = nums.length - 1;
        while (rl <= rr) {
            int m = (rl + rr) / 2;
            if (nums[m] <= target) {
                rl = m + 1;
            } else {
                rr = m - 1;
            }
        }
        if (ll <= rr) {
            res[0] = ll;
            res[1] = rr;
        }
        return res;
    }

}
