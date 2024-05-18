function minCostClimbingStairs(cost: number[]): number {
  const N = cost.length;
  let DP = Array(N + 1).fill(0);
  DP[0] = 0;
  DP[1] = 0;
  for (let i = 2; i <= N; i++) {
    DP[i] = Math.min(cost[i - 1] + DP[i - 1], cost[i - 2] + DP[i - 2]);
  }
  return DP[N];
}
