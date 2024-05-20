package org.algogosu.leetcode;

import java.util.Arrays;

// 746. Min Cost Climbing Stairs
public class LT746 {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[1001]; // 최대 1000개의 계단
        Arrays.fill(dp, 1000); // 배열을 최대값으로 초기화

        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            // 계단 1칸, 2칸 중 최소값을 선택
            dp[i] = cost[i];
            dp[i] = Math.min(dp[i] + dp[i - 1], dp[i] + dp[i - 2]);
        }

        // 마지막 계단 밟는 경우, 밟지 않는 경우 중 최소값 리턴
        return Math.min(dp[cost.length - 1], dp[cost.length - 2]);
    }
}
