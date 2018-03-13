package com.example.leetcode.String;

/**
 * <p>
 * 求斐波那契数列总和
 * </p>
 *
 * @author wangdejian
 * @since 2018/3/13
 */
public class Fibonacci {
    /**
     * 斐波那契数列指的是这样一个数列 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233，377，610，987，1597，2584，4181，6765，10946，17711，28657，46368……
     * 特别指出：第0项是0，第1项是第一个1。
     * 这个数列从第三项开始，每一项都等于前两项之和。
     * 在数学上，斐波纳契数列以如下被以递归的方法定义：F（0）=0，F（1）=1，F（n）=F(n-1)+F(n-2)（n≥2，n∈N*）
     */

    public static int fibonacci(int n) {

        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }

        int n1 = 1, n2 = 1, sum = 0;
        for (int i = 3; i < n; i++) {
            sum = n1 + n2;
            n1 = n2;
            n2 = sum;
        }

        return sum;
    }

    public static int fibonacci2(int n) {
        if (n < 0) {
            return -1;
        } else if (n == 0) {
            return 0;
        } else if (n == 1 || n == 2) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }

    }
}
