package org.algogosu.leetcode;

// Longest Common Prefix
public class LT14 {
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            StringBuilder result = new StringBuilder();
            // 문자의 길이가 최대 200이므로 200번 반복
            for(int i = 0; i<200; i++){
                // 문자열의 길이가 i보다 작으면 종료
                if (strs[0].length() <= i) {
                    break;
                }
                String commonStr = String.valueOf(strs[0].charAt(i)); // 첫 번째 문자열의 i번째 문자
                // 모든 문자열의 i번째 문자가 같은지 확인
                for(int j = 0; j<strs.length; j++){
                    // 문자열의 길이가 i보다 작으면 종료
                    if (strs[j].length() <= i) {
                        commonStr = "";
                        break;
                    }
                    // i번째 문자가 다르면 종료
                    if (!commonStr.equals(String.valueOf(strs[j].charAt(i)))) {
                        commonStr = "";
                    }
                }
                // 모든 문자열의 i번째 문자가 같으면 결과에 추가
                if (!commonStr.isEmpty()) {
                    result.append(commonStr);
                } else {
                    break;
                }
            }

            return result.toString();
        }
    }
}
