package com.example.leetcode.Array;

/**
 * <p>
 * 66. 加一
 * </p>
 *
 * @author wangdejian
 * @since 2018/4/16
 */
public class PlusOne {

    /**
     * 给定一个非负整数组成的非空数组，给整数加一。
     * <p>
     * 可以假设整数不包含任何前导零，除了数字0本身。
     * <p>
     * 最高位数字存放在列表的首位。
     */
    /**
     * 将一个数字的每个位上的数字分别存到一个一维向量中，最高位在最开头，我们需要给这个数字加一，
     * 即在末尾数字加一，如果末尾数字是9，那么则会有进位问题，而如果前面位上的数字仍为9，则需要继续向前进位。
     * 具体算法如下：首先判断最后一位是否为9，若不是，直接加一返回，若是，则该位赋0，再继续查前一位，
     * 同样的方法，知道查完第一位。如果第一位原本为9，加一后会产生新的一位，那么最后要做的是，查运算完的
     * 第一位是否为0，如果是，则在最前头加一个1。
     *
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for(int i=n-1; i>=0; i--) {
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }

        int[] newNumber = new int [n+1];
        newNumber[0] = 1;

        return newNumber;
    }
}
