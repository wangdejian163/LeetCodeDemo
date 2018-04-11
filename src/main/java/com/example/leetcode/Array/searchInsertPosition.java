package com.example.leetcode.Array;

/**
 * <p>
 * 35. 搜索插入位置
 * </p>
 *
 * @author wangdejian
 * @since 2018/4/11
 */
public class searchInsertPosition {

    /**
     * 给定一个排序数组和一个目标值，如果在数组中找到目标值则返回索引。如果没有，返回到它将会被按顺序插入的位置。
     * <p>
     * 你可以假设在数组中无重复元素。
     * <p>
     * <p>
     * <p>
     * 案例 1:
     * <p>
     * 输入: [1,3,5,6], 5
     * 输出: 2
     * <p>
     * <p>
     * 案例 2:
     * <p>
     * 输入: [1,3,5,6], 2
     * 输出: 1
     * <p>
     * <p>
     * 案例 3:
     * <p>
     * 输入: [1,3,5,6], 7
     * 输出: 4
     * <p>
     * <p>
     * 案例 4:
     * <p>
     * 输入: [1,3,5,6], 0
     * 输出: 0
     */
    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (target <= nums[i]) {
                return i;
            }
        }
        return nums.length;

    }

}
