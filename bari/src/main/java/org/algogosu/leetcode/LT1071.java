package org.algogosu.leetcode;

// Greatest Common Divisor of Strings
public class LT1071 {
    class Solution {
        public String gcdOfStrings(String str1, String str2) {
            // 공통 접두사 찾기
            StringBuilder commonPrefix = new StringBuilder();
            for (int i = 0; i < Math.min(str1.length(), str2.length()); i++) {
                if (str1.charAt(i) == str2.charAt(i)) {
                    commonPrefix.append(str1.charAt(i));
                } else {
                    break;
                }
            }

            // 공통 접두사로 나누어지는지 확인
            String prefix = commonPrefix.toString();
            while (!prefix.isEmpty()) {
                if (canForm(str1, prefix) && canForm(str2, prefix)) {
                    return prefix;
                }
                // prefix를 한 글자씩 줄여가며 확인
                prefix = prefix.substring(0, prefix.length() - 1);
            }

            return "";
        }

        // prefix로 str을 나눌 수 있는지 확인
        private boolean canForm(String str, String prefix) {
            int len = prefix.length();
            if (str.length() % len != 0) {
                return false;
            }
            for (int i = 0; i < str.length(); i += len) {
                if (!str.substring(i, i + len).equals(prefix)) {
                    return false;
                }
            }
            return true;
        }
    }

}
