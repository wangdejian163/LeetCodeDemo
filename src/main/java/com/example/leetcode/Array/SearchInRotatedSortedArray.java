package com.example.leetcode.Array;

/**
 * <p>
 * 33. 搜索旋转排序数组
 * </p>
 *
 * @author wangdejian
 * @since 2018/4/12
 */
public class SearchInRotatedSortedArray {
    /**
     * 假设按照升序排序的数组在预先未知的某个关键点上旋转。
     * <p>
     * （即 0 1 2 4 5 6 7 将变成 4 5 6 7 0 1 2）。
     * <p>
     * 给你一个目标值来搜索，如果数组中存在这个数则返回它的索引，否则返回 -1。
     * <p>
     * 你可以假设数组中不存在重复。
     */
    // 使用二分查找算法查询
    public int search(int[] nums, int target) {
        // 在旋转数组时，数组的一半仍然按排序顺序排列.
        // 当进行二分搜索时，我们可以判断哪个部分是有序的，以及目标是否在该范围内，如果是，继续在那一半的搜索，如果不在另一半继续
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[start] <= nums[mid]) {
                if (target < nums[mid] && target >= nums[start]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }

            if (nums[mid] <= nums[end]) {
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return -1;
    }
}
