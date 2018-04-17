package com.example.leetcode.Array;

import java.util.Arrays;

/**
 * <p>
 * 88. 合并两个有序数组
 * </p>
 *
 * @author wangdejian
 * @since 2018/4/17
 */
public class MergeSortedArray {
    /**
     * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1中，使得 num1 成为一个有序数组。
     * <p>
     * 注意:
     * <p>
     * 你可以假设 nums1有足够的空间（空间大小大于或等于m + n）来保存 nums2 中的元素。在 nums1 和 nums2 中初始化的元素的数量分别是 m 和 n。
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];

        }
        Arrays.sort(nums1);

    }
}
