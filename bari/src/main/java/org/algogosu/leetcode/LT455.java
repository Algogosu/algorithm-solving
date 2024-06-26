package org.algogosu.leetcode;

import java.util.Arrays;

// Assign Cookies
public class LT455 {
    class Solution {
        // 2중 for문 사용
        public int findContentChildren1(int[] g, int[] s) {
            // 정렬
            Arrays.sort(g);
            Arrays.sort(s);

            int result = 0;
            // 자녀 배열 순회
            for(int i = 0; i<g.length; i++){
                // 쿠키 배열 순회
                for(int j = 0; j<s.length; j++){
                    if (g[i] <= s[j]) { // 만족하는 쿠키를 주는 경우
                        s[j] = 0;
                        result++;
                        break;
                    }
                }
            }
            return result;
        }

        // GPT가 풀어준 코드 (포인터 개념 사용)
        public int findContentChildren2(int[] g, int[] s) {
            // 자녀의 만족도 지수와 쿠키 크기를 정렬
            Arrays.sort(g);
            Arrays.sort(s);

            int i = 0; // 자녀 포인터
            int j = 0; // 쿠키 포인터

            // 두 배열을 순회
            while (i < g.length && j < s.length) {
                // 자녀의 만족도 지수를 쿠키 크기로 만족시킬 수 있는 경우
                if (g[i] <= s[j]) {
                    i++; // 다음 자녀로 이동
                }
                j++; // 다음 쿠키로 이동 (만족한 경우든 아니든 다음 쿠키를 검사)
            }

            return i; // 만족한 자녀 수
        }
    }
}
