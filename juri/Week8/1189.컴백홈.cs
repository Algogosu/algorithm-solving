using System;

namespace BOJ
{
    internal class Program
    {
        static int R, C, K;
        static char[,] map;
        static bool[,] visited;
        static int[] dx = { -1, 1, 0, 0 }; // 상하좌우 이동
        static int[] dy = { 0, 0, -1, 1 }; // 상하좌우 이동
        static int count = 0;

        static void Main(string[] args)
        {
            string[] inputs = Console.ReadLine().Split();
            R = int.Parse(inputs[0]);
            C = int.Parse(inputs[1]);
            K = int.Parse(inputs[2]);

            map = new char[R, C];
            visited = new bool[R, C];

            for (int i = 0; i < R; i++)
            {
                string row = Console.ReadLine();
                for (int j = 0; j < C; j++)
                {
                    map[i, j] = row[j];
                }
            }

            visited[R - 1, 0] = true; // 시작점 방문 표시
            DFS(R - 1, 0, 1); // (R-1, 0)에서 시작, 거리 1로 시작

            Console.WriteLine(count);
        }

        static void DFS(int x, int y, int dist)
        {
            if (x == 0 && y == C - 1) // 목표 지점 도달
            {
                if (dist == K)
                {
                    count++;
                }
                return;
            }

            for (int i = 0; i < 4; i++)
            {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < R && ny >= 0 && ny < C && !visited[nx, ny] && map[nx, ny] == '.')
                {
                    visited[nx, ny] = true;
                    DFS(nx, ny, dist + 1);
                    visited[nx, ny] = false;
                }
            }
        }
    }
}
