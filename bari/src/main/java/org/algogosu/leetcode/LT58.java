package org.algogosu.leetcode;

import java.util.Arrays;

// Length of Last Word
public class LT58 {
    // 직접 짠 코드
    public int lengthOfLastWord1(String s) {
        String[] arr = Arrays.stream(s.split(" ")).filter((a) -> !a.equals(" ")).toArray(String[]::new);
        return arr[arr.length - 1].length();
    }

    // AI가 수정해준 코드
    public int lengthOfLastWord2(String s) {
        s = s.trim(); // 앞뒤 공백 제거

        int length = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                break;
            }
            length++;
        }

        return length;
    }
}
