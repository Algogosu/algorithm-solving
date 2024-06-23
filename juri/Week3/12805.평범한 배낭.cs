namespace BOJ
{
    internal class Program
    {
        static void Main(string[] args)
        {
            string[] nums = Console.ReadLine().Split(' ');
            int n = int.Parse(nums[0]);
            int limit = int.Parse(nums[1]);
            int[,] list = new int[n, 2];
            int[,] dp = new int[n + 1, limit + 1];

            for (int i = 0; i < n; i++)
            {
                string[] str = Console.ReadLine().Split(' ');
                list[i, 0] = int.Parse(str[0]); // Weight
                list[i, 1] = int.Parse(str[1]); // Value
            }

            for (int i = 1; i <= n; i++)
            {
                int weight = list[i - 1, 0];
                int value = list[i - 1, 1];
                for (int j = 0; j <= limit; j++)
                {
                    if (j < weight)
                        dp[i, j] = dp[i - 1, j];
                    else
                        dp[i, j] = Math.Max(dp[i - 1, j], dp[i - 1, j - weight] + value);
                }
            }

            Console.WriteLine(dp[n, limit]);
        }
    }
}