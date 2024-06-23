package org.algogosu.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 소수&팰린드롬
public class BOJ1747 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 1 ~ 1,000,000
        int MAX_SIZE = 1003002; // N이 1,000,000인 경우 1,003,001이 답

        boolean[] isPrime = new boolean[MAX_SIZE];
        for (int i = 2; i < MAX_SIZE; i++) {
            isPrime[i] = true;
        }

        // 에라토스테네스의 체로 소수 찾기
        for (int i = 2; i * i < MAX_SIZE; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < MAX_SIZE; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // 소수이면서 팰린드롬인지 확인
        for (int i = N; i < MAX_SIZE; i++) {
            if (isPrime[i] && isPalindrome(i)) {
                System.out.println(i);
                return;
            }
        }
    }

    private static boolean isPalindrome(int n) {
        String s = String.valueOf(n);
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
