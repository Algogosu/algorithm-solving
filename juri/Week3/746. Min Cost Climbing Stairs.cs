public class Solution
{
    public int MinCostClimbingStairs(int[] cost)
    {
        //계산 결과 담을 배열 생성
        int n = cost.Length;
        int[] result = new int[n];
        //Bottom up 
        for (int i = 0; i < n; i++)
        {
            if (i < 2) result[i] = cost[i];
            else result[i] = cost[i] + Math.Min(result[i - 1], result[i - 2]);
        }
        return Math.Min(result[n - 1], result[n - 2]);
    }
}