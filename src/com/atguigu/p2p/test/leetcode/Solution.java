package com.atguigu.p2p.test.leetcode;

import java.util.HashMap;
import java.util.Map;
/**
 * @author njy
 * @date 2019/5/16
 * @description 无重复字符的最长子串
 */
public class Solution {
    public static void main(String[] args) {
        /**
         * 定义字符到索引的映射，而不是使用集合来判断一个字符是否存在。 当我们找到重复的字符时，我们可以立即跳过该窗口。
         *
         * 也就是说，如果 s[j] 在 [i, j)[i,j)范围内有与 j'
         * 重复的字符，我们不需要逐渐增加 i 。 我们可以直接跳过 [i，j']
         * 范围内的所有元素，并将 i 变为 j' + 1
         */
        System.out.println(lengthOfLongestSubstring("jhfahgia"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            char curChar = s.charAt(j);
            if (map.containsKey(curChar)) {
                i = Math.max(map.get(curChar), i);
            }
            map.put(curChar, j + 1);

            ans = Math.max(ans, j - i + 1);
        }
        return ans;
    }
}
