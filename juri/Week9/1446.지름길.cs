using System;
using System.Collections.Generic;

class Program
{
    const int INF = int.MaxValue;

    static List<Node>[] g;
    static int[] dist;
    static int n, d;

    static void Main()
    {
        var input = Console.ReadLine().Split();
        n = int.Parse(input[0]);
        d = int.Parse(input[1]);

        g = new List<Node>[10001];
        for (int i = 0; i <= 10000; i++)
        {
            g[i] = new List<Node>();
        }

        dist = new int[10001];
        Array.Fill(dist, INF);

        for (int i = 0; i < n; i++)
        {
            input = Console.ReadLine().Split();
            int x = int.Parse(input[0]);
            int y = int.Parse(input[1]);
            int s = int.Parse(input[2]);
            g[x].Add(new Node(s, y));
        }

        Dijkstra();
    }

    static void Dijkstra()
    {
        var pq = new SortedSet<Node>(new NodeComparer());
        dist[0] = 0;
        for (int i = 0; i <= d; i++)
        {
            if (i != 0)
                dist[i] = Math.Min(dist[i], dist[i - 1] + 1);

            if (g[i].Count > 0)
            {
                pq.Add(new Node(dist[i], i));

                while (pq.Count > 0)
                {
                    var node = pq.Min;
                    pq.Remove(node);

                    int distance = node.dist;
                    int now = node.idx;

                    if (distance > dist[now])
                        continue;

                    foreach (var next in g[now])
                    {
                        if (next.idx > d)
                            continue;

                        int cost = distance + next.dist;

                        if (cost < dist[next.idx])
                        {
                            pq.Add(new Node(cost, next.idx));
                            dist[next.idx] = cost;
                        }
                    }
                }
            }
        }

        Console.WriteLine(dist[d]);
    }

    class Node
    {
        public int dist;
        public int idx;

        public Node(int dist, int idx)
        {
            this.dist = dist;
            this.idx = idx;
        }
    }

    class NodeComparer : IComparer<Node>
    {
        public int Compare(Node x, Node y)
        {
            return x.dist.CompareTo(y.dist);
        }
    }
}
