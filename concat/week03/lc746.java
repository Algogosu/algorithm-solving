/*
1. 계단 수가 2개인 경우, 두 계단 중 더 작은 비용을 반환합니다.
2. DP 배열을 초기화하여 첫 번째 계단부터 마지막 계단까지의 최소 비용을 계산합니다.
- 각 계단의 최소 비용은 이전 계단과 두 계단 전의 최소 비용 중 작은 값에 해당 계단의 비용을 더해 결정됩니다.
3. 마지막 계단까지 오르는 데 필요한 최소 비용을 DP 배열에서 반환합니다.
*/

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        // 계단 수가 2개인 경우, 더 작은 비용을 반환
        if (cost.length == 2) {
            return Math.min(cost[0], cost[1]);
        }

        // DP 배열 초기화: 각 계단까지의 최소 비용을 저장
        int[] dp = new int[cost.length + 1];

        // 첫 번째 계단까지의 최소 비용은 첫 번째 계단의 비용
        dp[1] = cost[0];

        // 두 번째 계단까지의 최소 비용은 첫 번째와 두 번째 중 작은 값
        dp[2] = Math.min(cost[0], cost[1]);

        // 세 번째 계단까지의 최소 비용은 첫 번째 계단에서 세 번째 계단으로 가는 비용 또는 두 번째 계단에서 세 번째 계단으로 가는 비용 중 작은 값
        dp[3] = Math.min(dp[2] + cost[2], cost[1]);

        // 나머지 계단의 최소 비용 계산
        for (int i = 4; i < cost.length + 1; i++) {
            // 현재 계단까지의 최소 비용은 이전 계단에서 오는 비용과 두 계단 전에서 오는 비용 중 작은 값
            dp[i] = Math.min(dp[i-1] + cost[i-1], dp[i-2] + cost[i-2]);
        }

        // 마지막 계단까지의 최소 비용 반환
        return dp[cost.length];
    }
}
