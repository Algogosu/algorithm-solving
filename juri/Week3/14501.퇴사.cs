namespace BOJ
{
    internal class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine().ToString());
            int[,] list = new int[n, 2];
            int[] result = new int[n + 1]; // n+1 크기로 변경
            Array.Fill(result, 0);

            for (int i = 0; i < n; i++)
            {
                string[] str = Console.ReadLine().Split(' ');
                list[i, 0] = int.Parse(str[0]); // i로 변경
                list[i, 1] = int.Parse(str[1]); // i로 변경
            }

            for (int j = n - 1; j >= 0; j--)
            {
                int _currentDay = list[j, 0];
                int _currentMoney = list[j, 1];
                if (j + _currentDay <= n) // 조건 변경
                {
                    // _currentMoney와 _currentDay 이후의 result 값 중 최대값을 result[j]에 저장
                    result[j] = Math.Max(_currentMoney + result[j + _currentDay], result[j + 1]);
                }
                else
                {
                    result[j] = result[j + 1];
                }
            }
            Console.WriteLine(result[0]); // 첫 번째 요소 출력
        }
    }
}