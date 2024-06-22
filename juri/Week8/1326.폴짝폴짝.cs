using System;
using System.Linq;
using System.Collections.Generic;

namespace BOJ
{
    internal class Program
    {
        static void Main(string[] args)
        {
            int total = Int32.Parse(Console.ReadLine().Trim());
            int[] stones = Console.ReadLine().Trim().Split(' ').Select(x => Int32.Parse(x)).ToArray();
            int[] startAndGoal = Console.ReadLine().Trim().Split(' ').Select(x => Int32.Parse(x)).ToArray();
            int start = startAndGoal[0];
            int goal = startAndGoal[1];

            if (start == goal)
            {
                Console.WriteLine(0);
                return;
            }

            Console.WriteLine(BfsJump(stones, start, goal, total));
        }

        static int BfsJump(int[] stones, int start, int goal, int total)
        {
            Queue<(int index, int steps)> queue = new Queue<(int index, int steps)>();
            bool[] visited = new bool[total];

            queue.Enqueue((start, 0));
            visited[start - 1] = true;

            while (queue.Count > 0)
            {
                var (currentIndex, cnt) = queue.Dequeue();

                if (currentIndex == goal)
                {
                    return cnt;
                }

                int currentVal = stones[currentIndex - 1];

                for (int step = 1; currentIndex + step * currentVal <= total; step++)
                {
                    int nextIndex = currentIndex + step * currentVal;
                    if (nextIndex <= total && !visited[nextIndex - 1])
                    {
                        queue.Enqueue((nextIndex, cnt + 1));
                        visited[nextIndex - 1] = true;
                    }
                }

                for (int step = 1; currentIndex - step * currentVal > 0; step++)
                {
                    int nextIndex = currentIndex - step * currentVal;
                    if (nextIndex > 0 && !visited[nextIndex - 1])
                    {
                        queue.Enqueue((nextIndex, cnt + 1));
                        visited[nextIndex - 1] = true;
                    }
                }
            }

            return -1;
        }
    }
}
