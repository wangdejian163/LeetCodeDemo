package com.example.leetcode.String;

/**
 * <p>
 * 有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶、3阶。请实现一个方法，计算小孩有多少种上楼的方式。为了防止溢出，请将结果Mod 1000000007
 * <p>
 * 给定一个正整数int n，请返回一个数，代表上楼的方式数。保证n小于等于100000。
 * </p>
 *
 * @author wangdejian
 * @since 2018/5/30
 */
public class GoUpStairs {

    public int countWays(int n) {

        if (n < 1) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }
        if (n == 3) {
            return 4;
        }

        int mod = 1000000007;
        int array[] = new int[n];
        array[0] = 1;
        array[1] = 2;
        array[2] = 4;
        for (int i = 3; i < n; i++) {
            array[i] = ((array[i - 1] + array[i - 2]) % mod + array[i - 3] % mod) % mod;
        }
        return array[n - 1];
    }

}
