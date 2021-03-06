package cn.hackcoder;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by thinsky on 2017/8/1.
 */
public class Solution {
    public String validIPAddress(String IP) {
        if (IP.matches(".*[.:]$|^[.:].*")) return "Neither";
        String[] ipv4Strs = IP.split("\\.");
        if (ipv4Strs.length == 4) {
            for (int i = 0; i < ipv4Strs.length; i++) {
                if (!ipv4Strs[i].matches("[0-9]*") || "".equals(ipv4Strs[i]) ||
                        ipv4Strs[i].length() > 3 || Integer.parseInt(ipv4Strs[i]) > 255 || (ipv4Strs[i].startsWith("0") && ipv4Strs[i].length() > 1))
                    return "Neither";
            }
            return "IPv4";
        }
        String[] ipv6Strs = IP.split(":");
        if (ipv6Strs.length == 8) {
            for (int i = 0; i < ipv6Strs.length; i++) {
                if (!ipv6Strs[i].matches("[0-9a-fA-F]*") || "".equals(ipv6Strs[i]) || ipv6Strs[i].length() > 4 || (ipv6Strs[i].matches(".*[A-F].*") && ipv6Strs[i].startsWith("0") && ipv6Strs[i].length() > 1))
                    return "Neither";
            }
            return "IPv6";
        }
        return "Neither";
    }
}
