package org.algogosu.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 퇴사
public class BOJ14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 날짜 수

        int dp[] = new int[n + 1];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int t = Integer.parseInt(input[0]); // 기간
            int p = Integer.parseInt(input[1]); // 금액

            // i+1일의 최대 수익 갱신
            dp[i + 1] = Math.max(dp[i], dp[i + 1]);

            // i일에 상담을 하는 경우
            if (i + t <= n) {
                dp[i + t] = Math.max(dp[i + t], dp[i] + p);
            }
        }

        br.close();
        System.out.println(dp[n]);
    }
}
