package com.example.leetcode.String;

/**
 * <p></p>
 *
 * @author wangdejian
 * @since 2018/3/3
 */
public class ZigZagConversion {

    /**
     * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
     * (you may want to display this pattern in a fixed font for better legibility)
     * P   A   H   N
     * A P L S I I G
     * Y   I   R
     * And then read line by line: "PAHNAPLSIIGYIR"
     * Write the code that will take a string and make this conversion given a number of rows:
     * string convert(string text, int nRows);
     * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
     *
     */

    //  s = 0123456789  numRows = 3

    /**
     * 排序规则
     * 0   4   8
     * 1 3 5 7 9
     * 2   6
     * 生成结果：1592468037
     */
    public String convert(String s, int numRows) {

        if (s.length() <= 1 || numRows >= s.length()) {
            return s;
        }

        StringBuilder[] sb = new StringBuilder[numRows];
        // new numRows个StringBuilder来存放不同下标的字符
        for (int i = 0; i < numRows; i++) {
            sb[i] = new StringBuilder();
        }
        int flag = 1;
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            sb[index].append(s.charAt(i));
            if (index == 0) {
                flag = 1;
            }
            if (index == numRows - 1) {
                flag = -1;
            }
            index += flag;
        }

        String str = "";
        for (int i = 0; i < sb.length; i++) {
            str += sb[i];
        }

        return str.toString();
    }


}
