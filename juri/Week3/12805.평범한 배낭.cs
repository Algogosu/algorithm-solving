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
            int[] result = new int[n + 1]; // n+1 크기로 변경
            Array.Fill(result, 0);

            for (int i = 0; i < n; i++)
            {
                string[] str = Console.ReadLine().Split(' ');
                list[i, 0] = int.Parse(str[0]); // Weight
                list[i, 1] = int.Parse(str[1]); // Value
            }

            int sumW = 0;
            for (int j = n - 1; j >= 0; j--)
            {
                int currentW = list[j, 0];
                int currentV = list[j, 1];
                if (limit >= currentW + sumW)
                {
                    if (j != 0) // 마지막 요소가 아니라면
                    {
                        int lastW = list[j - 1, 0];
                        int lastV = list[j - 1, 1];

                        if (lastW + currentW <= limit && result[j + 1] < lastV + currentV)
                        {
                            sumW = currentW + lastW;
                            result[j] = lastV + currentV;
                            continue;
                        }
                    }
                }
                result[j] = result[j + 1];
            }
            Console.WriteLine(result[0]);
        }
    }
}
