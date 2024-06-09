using System.Linq;
namespace BOJ
{
    internal class Program
    {
        static void Main(string[] args)
        {
            int[] numbers = new int[4] { 1, 5, 10, 50 };
            int N = Int32.Parse(Console.ReadLine());
            bool[,] dp = new bool[N + 1, N * 50 + 1];

            dp[0, 0] = true;
            for (int i = 1; i <= N; i++)
            {
                for (int j = 0; j <= N * 50; j++)
                {
                    foreach (int number in numbers)
                    {
                        if (j - number >= 0)
                        {
                            dp[i, j] |= dp[i - 1, j - number];
                        }
                    }
                }
            }

            int count = 0;
            for (int i = 0; i <= N * 50; i++)
            {
                if (dp[N, i])
                {
                    count++;
                }
            }

            Console.WriteLine(count);
        }
    }
}
