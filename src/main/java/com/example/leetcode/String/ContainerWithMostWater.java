package com.example.leetcode.String;

/**
 * <p>
 * <p>
 * </p>
 *
 * @author wangdejian
 * @since 2018/3/6
 */
public class ContainerWithMostWater {
    /**
     * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai).
     * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines,
     * which together with x-axis forms a container, such that the container contains the most water.Note:
     * You may not slant the container and n is at least 2.
     *
     */
    /**
     * 题意为在二维坐标中(i, ai) 和 (i, 0) 连成一条线，(n, an) 和 (n, 0)连成另一条线。这两条线和X轴像木桶一样，使其包含最多的水，容积最大。
     * 两条线需要取较短的一个形成木桶，"水"才不会流出.最后计算出该木桶的面积即可.
     * <p>
     * 最简单的就是暴力搜索，不过这个肯定就是超时了.
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {

        if (height == null || height.length < 2) {
            return 0;
        }

        int maxArea = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int shortY = height[i] - height[j] > 0 ? height[j] : height[i];
                int longX = j - i;
                maxArea = maxArea - shortY * longX > 0 ? maxArea : shortY * longX;
            }
        }
        return maxArea;
    }

    /**
     * 下面的方法是通过设置两个指针在数组的两端初始化。每次将较小的值指针移至内部数组。
     * 最后在两个指针相遇之后，所有可能的最大情况都被扫描到.
     *
     * @param height
     * @return
     */
    public int maxArea2(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }

        int maxArea = 0;

        // 初始化左右两个指针
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            // 两条线取较短那个
            int shortY = height[left] - height[right] > 0 ? height[right] : height[left];
            // 计算宽度
            int longX = right - left;
            // 计算出最大值
            maxArea = maxArea - shortY * longX > 0 ? maxArea : shortY * longX;
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}