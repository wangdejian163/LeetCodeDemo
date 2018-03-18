package com.example.leetcode.String;

/**
 * <p>
 * 71. Simplify Path
 * </p>
 *
 * @author wangdejian
 * @since 2018/3/18
 */
public class SimplifyPath {

    /**
     * Given an absolute path for a file (Unix-style), simplify it.
     * For example,
     * path = "/home/", => "/home"
     * path = "/a/./b/../../c/", => "/c"
     * 这道题让简化给定的路径， 当path = "/a/./b/../c/", => "/a/c"和path = "/a/./b/c/", => "/a/b/c"，
     * 中间是"."的情况直接去掉，是".."时删掉它上面挨着的一个路径，而下面的边界条件给的一些情况中可以得知，如果是空的话返回"/"，如果有多个"/"只保留一个
     */

    public String simplifyPath(String path) {
        String[] splitPath = path.split("/");
        String[] stack = new String[splitPath.length];
        int index = 0;
        for (int i = 0; i < splitPath.length; i++) {
            if (splitPath[i].equals(".") || splitPath[i].equals("")) {
                continue;
            } else if (splitPath[i].equals("..")) {
                if (index > 0) {
                    index--;
                }
            } else {
                stack[index++] = splitPath[i];

            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < index; i++) {
            result.append("/");
            result.append(stack[i]);
        }

        return result.length() == 0 ? "/" : result.toString();
    }

}
