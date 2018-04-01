package com.example.leetcode.String;

/**
 * <p>
 * 468. Validate IP Address
 * </p>
 *
 * @author wangdejian
 * @since 2018/4/1
 */
public class ValidateIPAddress {

    /**
     * 验证ip是“IPv4”还是“IPv6”。
     *
     * @param IP
     * @return
     */
    public String validIPAddress(String IP) {
        if (IP == null || IP.length() < 7) {
            return "Neither";
        }
        // 判断IPV4
        if (isIPv4(IP)) {
            return "IPv4";
        } else if (isIPv6(IP)) {
            return "IPv6";
        } else {
            return "Neither";
        }


    }

    private boolean isIPv4(String ip) {
        // 开头结尾必须是数字.
        if (ip.charAt(0) == '.' || ip.charAt(ip.length() - 1) == '.') {
            return false;
        }

        String[] splitIp = ip.split("\\.");
        if (splitIp.length != 4) {
            return false;
        }
        for (int i = 0; i < splitIp.length; i++) {
            // 不能以0开头.
            if (splitIp[i].startsWith("0") && splitIp[i].length() > 1) {
                return false;
            }

            try {
                if (Integer.parseInt(splitIp[i]) < 0 || Integer.parseInt(splitIp[i]) > 255
                        || (Integer.parseInt(splitIp[i]) == 0 && splitIp[i].charAt(0) != '0')) {
                    return false;
                }
            } catch (NumberFormatException e) {
                return false;
            }

        }
        return true;
    }

    private boolean isIPv6(String ip) {
        if (ip.length() < 15 || ip.charAt(0) == ':' || ip.charAt(ip.length() - 1) == ':') {
            return false;
        }
        String[] tokens = ip.split("\\:");
        if (tokens.length != 8) {
            return false;
        }
        for (String token : tokens) {
            if (!isValidIPv6Token(token)) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidIPv6Token(String token) {
        if (token.length() > 4 || token.length() == 0) {
            return false;
        }
        char[] chars = token.toCharArray();
        for (char c : chars) {
            boolean isDigit = c >= 48 && c <= 57;
            boolean isUppercaseAF = c >= 65 && c <= 70;
            boolean isLowerCaseAF = c >= 97 && c <= 102;
            if (!(isDigit || isUppercaseAF || isLowerCaseAF)) {
                return false;
            }
        }
        return true;
    }

}
