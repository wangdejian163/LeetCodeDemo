package com.example.leetcode.String;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 93. Restore IP Addresses
 * </p>
 *
 * @author wangdejian
 * @since 2018/3/20
 */
public class RestoreIPAddresses {

    /**
     * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
     * For example:
     * Given "25525511135",
     * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
     */

    /**
     * 解题思路： 给定字符串转换成ip.首先字符串长度有范围限定，ip地址被“.”分为了四段，
     * 每一段最少需要1个数字，最多可以有三个数字。则s长度范围是4~12.
     * 需要注意：每一段不能大于255，每一段如果不是一个字符的话，不可以零开头.
     */
    public List<String> restoreIpAddresses(String s) {

        List<String> res = new ArrayList<>();
        if (s == null || s.length() < 4 || s.length() > 12) {
            return res;
        }

        int len = s.length();
        // 循环将字符串s分成4个子字符串：s1，s2，s3，s4。检查每个子字符串是否有效
        for (int i = 1; i < 4 && i < len - 2; i++) {
            for (int j = i + 1; j < i + 4 && j < len - 1; j++) {
                for (int k = j + 1; k < j + 4 && k < len; k++) {
                    String s1 = s.substring(0, i);
                    String s2 = s.substring(i, j);
                    String s3 = s.substring(j, k);
                    String s4 = s.substring(k, s.length());
                    if (isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)) {
                        res.add(s1 + "." + s2 + "." + s3 + "." + s4);
                    }
                }
            }
        }

        return res;
    }

    private boolean isValid(String s) {
        if (Integer.parseInt(s) > 255 || (s.length() > 1 && s.charAt(0) == '0') || s.length() > 3 || s.length() == 0) {
            return false;
        }
        return true;
    }


    // 深度优先搜索（DFS）是从某个状态开始不断转移状态直到无法转移为止，然后退回到前一步状态继续转移其他状态，可以想象为一个沿树爬行的虫子，
    // 在一个交叉口他会首先随机选择一条分岔路口一直走下去直到死路为止，然后会返回到这个交叉口沿着另一条分支爬行下去，直到遍历所有可能的路径为止。
    // 根据这个特点，DFS算法用递归来实现比较简单
    public List<String> restoreIpAddresses2(String s) {
        List<String> solutions = new ArrayList<String>();
        restoreIp(s, solutions, 0, "", 0);
        return solutions;
    }

    private void restoreIp(String ip, List<String> solutions, int idx, String restored, int count) {
        if (count > 4) {
            return;
        }

        if (count == 4 && idx == ip.length()) {
            solutions.add(restored);
        }

        // 每一段最长3位，最短一位,总共4段.
        for (int i = 1; i < 4 && idx + i <= ip.length(); i++) {
            String s = ip.substring(idx, idx + i);
            if (s.length() > 3 || s.length() == 0 || Integer.parseInt(s) > 255 || (s.length() > 1 && s.charAt(0) == '0')) {
                continue;
            }
            restoreIp(ip, solutions, idx + i, restored + s + (count == 3 ? "" : "."), count + 1);
        }
    }

}
