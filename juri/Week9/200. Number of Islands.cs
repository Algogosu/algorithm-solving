public class Solution
{
    public int NumIslands(char[][] grid)
    {
        int[] x = new int[] { 0, 0, -1, 1 };
        int[] y = new int[] { 1, -1, 0, 0 }; //상하좌우
        int row = grid.Length;
        int column = grid[0].Length;
        int result = 0;
        int[,] visited = new int[row, column];

        void bfs(int i, int j)
        {
            visited[i, j] = 1;

            for (int k = 0; k < 4; k++)
            {
                int movedRow = i + x[k];
                int movedCol = j + y[k];
                if (movedRow >= 0 && movedRow < row && movedCol >= 0 && movedCol < column && visited[movedRow, movedCol] == 0 && grid[movedRow][movedCol] == '1')
                {
                    bfs(movedRow, movedCol);
                }
            }

        }

        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < column; j++)
            {
                if (visited[i, j] == 0 && grid[i][j] == '1')
                {
                    //bfs 를 시작할때 result++ 을 해주면 땅의 갯수를 셀 수 있다. 
                    result++;
                    bfs(i, j);
                }
            }
        }

        return result;
    }
}