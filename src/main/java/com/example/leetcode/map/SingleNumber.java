package com.example.leetcode.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * <p>
 * 136. 只出现一次的数字
 * </p>
 *
 * @author wangdejian
 * @since 2018/5/28
 */
public class SingleNumber {

    /**
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     * <p>
     * 说明：
     * <p>
     * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
     * <p>
     * 示例 1:
     * <p>
     * 输入: [2,2,1]
     * 输出: 1
     * 示例 2:
     * <p>
     * 输入: [4,1,2,1,2]
     * 输出: 4
     */
    public int singleNumber(int[] nums) {

        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> m :
                entries) {
            Integer value = m.getValue();
            if (value == 1) {
                res = m.getKey();
            }
        }
        return res;

    }

    public int singleNumber2(int[] nums) {
        int number = 0;
        for (int i = 0; i < nums.length; i++) {
            number ^= nums[i];
        }
        return number;

    }
}
