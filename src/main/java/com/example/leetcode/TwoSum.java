package com.example.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * <p>
 *     two sum
 * </p>
 *
 * @author wangdejian
 * @since 2018/2/26
 */
public class TwoSum {
    /**
     Given an array of integers, return indices of the two numbers such that they add up to a specific target.

     You may assume that each input would have exactly one solution.

     Example:
     Given nums = [2, 7, 11, 15], target = 9,

     Because nums[0] + nums[1] = 2 + 7 = 9,
     return [0, 1].
     给定一个整形数组和一个整数target，如果2个元素的下标满足相加的和为target。 返回这两个元素的下标
     假定每个输入，都会恰好有一个满足条件的返回结果。
     *
     */
    public int[] twoSum(int [] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        // 实现nums[i] + nums[j] = target
        for (int i = 0; i< nums.length; i++) {
            // 把数组值和对应下标以key,value形式存放到map中.
            Integer index = map.get(target - nums[i]);
            if (null == index) {
                map.put(nums[i], i);
            } else {
                return new int[]{i, index};
            }
        }

        return new int[]{0, 0};
    }
}
