package org.algogosu.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 젠장
public class BOJ1324 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        int n = Integer.parseInt(br.readLine()); // 주울 수 있는 쓰레기 최대 개수
        int[] input1 = new int[n];
        int[] input2 = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            input1[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            input2[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[n + 1][n + 1]; // dp[i][j]: i번째 쓰레기까지 주웠을 때 j번째 쓰레기까지 주울 수 있는 최대 개수


        for (int i = 1; i <= n; i++) {
            int maxValue = 0; // i번째 쓰레기가 j번째 쓰레기보다 작을 때 최대값
            for (int j = 1; j <= n; j++) {
                // i번째 쓰레기를 주울지 말지 결정
                if (input1[i - 1] == input2[j - 1]) {
                    dp[i][j] = maxValue + 1;
                } else { // 같지 않으면 이전 값으로
                    dp[i][j] = dp[i - 1][j];
                }
                // i번째 쓰레기가 j번째 쓰레기보다 작으면 maxValue 갱신
                if (input2[j - 1] < input1[i - 1]) {
                    maxValue = Math.max(maxValue, dp[i - 1][j]);
                }
            }
        }

        int result = 0;
        for (int j = 1; j <= n; j++) {
            result = Math.max(result, dp[n][j]);
        }
        System.out.println(result);
    }
}
