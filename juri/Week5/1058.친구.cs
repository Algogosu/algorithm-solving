using System.Linq;

namespace BOJ
{
    internal class Program
    {
        static void Main()
        {
            int n = int.Parse(Console.ReadLine());
            int[,] friends = new int[n, n];
            for (int i = 0; i < n; i++)
            {
                string[] input = Console.ReadLine().Split(' ');
                for (int j = 0; j < n; j++)
                {
                    friends[i, j] = int.Parse(input[j]);
                }
            }

            int maxFriends = 0;
            for (int i = 0; i < n; i++)
            {
                int count = 0;
                for (int j = 0; j < n; j++)
                {
                    if (i == j) continue;
                    if (friends[i, j] == 1 || friends[j].Where((x, k) => x == 1 && friends[i, k] == 1).Any())
                    {
                        count++;
                    }
                }
                maxFriends = Math.Max(maxFriends, count);
            }

            Console.WriteLine(maxFriends);
        }
    }
}
