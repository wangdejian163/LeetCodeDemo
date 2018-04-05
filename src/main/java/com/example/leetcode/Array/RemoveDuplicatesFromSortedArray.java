package com.example.leetcode.Array;

/**
 * <p>
 * 26. 从排序数组中删除重复项
 * </p>
 *
 * @author wangdejian
 * @since 2018/4/5
 */
public class RemoveDuplicatesFromSortedArray {
    /**
     * 给定一个有序数组，你需要原地删除其中的重复内容，使每个元素只出现一次,并返回新的长度。
     * <p>
     * 不要另外定义一个数组，您必须通过用 O(1) 额外内存原地修改输入的数组来做到这一点。
     * <p>
     * 示例：
     * <p>
     * 给定数组: nums = [1,1,2],
     * <p>
     * 你的函数应该返回新长度 2, 并且原数组nums的前两个元素必须是1和2
     * 不需要理会新的数组长度后面的元素
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[j]) {
                nums[++j] = nums[i];
            }
        }
        return j;

    }
}
