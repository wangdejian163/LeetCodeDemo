package com.example.leetcode.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 118. 杨辉三角
 * </p>
 *
 * @author wangdejian
 * @since 2018/4/21
 */
public class PascalTriangle {

    /**
     * 在杨辉三角中，每个数是它左上方和右上方的数的和。
     * <p>
     * 示例:
     * <p>
     * 输入: 5
     * 输出:
     * [
     * [1],
     * [1,1],
     * [1,2,1],
     * [1,3,3,1],
     * [1,4,6,4,1]
     * ]
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<Integer>();
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j));
                }
            }
            triangle.add(row);
        }

        return triangle;
    }

    /**
     * 杨辉三角二：
     * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
     *
     * @param rowIndex
     * @return
     */
    public List<Integer> getRow(int rowIndex) {
        Integer[] rowList = new Integer[rowIndex+1];
        rowList[0] = 1;
        for(int i=1; i<rowList.length;i++) {
            rowList[i] = (int)((long)rowList[i-1]*(rowIndex-(i-1))/(i));
        }
        return Arrays.asList(rowList);
    }
}
