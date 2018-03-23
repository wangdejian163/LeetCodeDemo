package com.example.leetcode.String;

/**
 * <p>
 * 165.Compare Version Numbers
 * </p>
 *
 * @author wangdejian
 * @since 2018/3/23
 */
public class CompareVersionNumbers {

    /**
     * Compare two version numbers version1 and version2.
     * If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.
     * <p>
     * You may assume that the version strings are non-empty and contain only digits and the . character.
     * The . character does not represent a decimal point and is used to separate number sequences.
     * For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.
     * <p>
     * Here is an example of version numbers ordering:
     * <p>
     * 0.1 < 1.1 < 1.2 < 13.37
     * 比较版本号大小.
     */
    public int compareVersion(String version1, String version2) {

        String[] sv1 = version1.split("\\.");
        String[] sv2 = version2.split("\\.");

        int maxLen = Math.max(sv1.length, sv2.length);
        for (int i = 0; i < maxLen; i++) {
            Integer i1 = i < sv1.length ? Integer.parseInt(sv1[i]) : 0;
            Integer i2 = i < sv2.length ? Integer.parseInt(sv2[i]) : 0;
            int result = i1.compareTo(i2);
            if (result != 0) {
                return result;
            }

        }
        return 0;
    }

}
