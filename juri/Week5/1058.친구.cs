using System.Linq;

namespace BOJ
{
    internal class Program
    {
        static void Main()
        {
            int n = int.Parse(Console.ReadLine());
            bool[,] friends = new bool[n, n];
            for (int i = 0; i < n; i++)
            {
                string input = Console.ReadLine();
                for (int j = 0; j < n; j++)
                {
                    friends[i, j] = input[j] == 'Y';
                }
            }

            int maxFriends = 0;
            for (int i = 0; i < n; i++)
            {
                int count = 0;
                for (int j = 0; j < n; j++)
                {
                    if (i == j) continue;
                    if (friends[i, j] || Enumerable.Range(0, n).Any(k => k != i && k != j && friends[i, k] && friends[k, j]))
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
