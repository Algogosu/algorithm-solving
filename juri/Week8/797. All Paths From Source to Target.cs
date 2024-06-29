using System;
using System.Collections.Generic;

public class Solution
{
    public IList<IList<int>> AllPathsSourceTarget(int[][] graph)
    {
        var result = new List<IList<int>>();
        var path = new List<int>();
        DFS(graph, 0, path, result);
        return result;
    }

    private void DFS(int[][] graph, int node, List<int> path, List<IList<int>> result)
    {
        path.Add(node);
        if (node == graph.Length - 1)
        {
            result.Add(new List<int>(path));
        }
        else
        {
            foreach (var neighbor in graph[node])
            {
                DFS(graph, neighbor, path, result);
            }
        }
        path.RemoveAt(path.Count - 1);
    }
}

// 예제 사용법
public class Program
{
    public static void Main()
    {
        var solution = new Solution();

        int[][] graph1 = new int[][] {
            new int[] { 1, 2 },
            new int[] { 3 },
            new int[] { 3 },
            new int[] { }
        };

        int[][] graph2 = new int[][] {
            new int[] { 4, 3, 1 },
            new int[] { 3, 2, 4 },
            new int[] { 3 },
            new int[] { 4 },
            new int[] { }
        };

        var result1 = solution.AllPathsSourceTarget(graph1);
        var result2 = solution.AllPathsSourceTarget(graph2);

        PrintResult(result1); // [[0, 1, 3], [0, 2, 3]]
        PrintResult(result2); // [[0, 4], [0, 3, 4], [0, 1, 3, 4], [0, 1, 2, 3, 4], [0, 1, 4]]
    }

    private static void PrintResult(IList<IList<int>> result)
    {
        foreach (var path in result)
        {
            Console.WriteLine("[" + string.Join(", ", path) + "]");
        }
    }
}
