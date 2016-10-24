package cn.hackcoder;

import java.util.HashMap;

/**
 * Created by Thinsky on 16/2/28.
 */
public class RomanToInteger {
    public int romanToInt(String s) {
        int result = 0;
        HashMap<String, Integer> map = new HashMap() {
            {
                put("I", 1);
                put("V", 5);
                put("X", 10);
                put("L", 50);
                put("C", 100);
                put("D", 500);
                put("M", 1000);

            }
        };
        for (int i = 0; i < s.length(); i++) {
            if (i == s.length() - 1) {
                return result + map.get("" + s.charAt(i));
            }
            if (map.get("" + s.charAt(i)) >= map.get("" + s.charAt(i + 1))) {
                result += map.get("" + s.charAt(i));
            } else {
                result -= map.get("" + s.charAt(i));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new RomanToInteger().romanToInt("DCXXI"));
    }
}
