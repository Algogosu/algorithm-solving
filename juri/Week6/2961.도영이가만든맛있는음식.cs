using System;
using System.Linq;

internal class Program
{
    static void Main(string[] args)
    {
        int num = Int32.Parse(Console.ReadLine());
        int[,] numList = new int[num, 2];
        bool[] isSelected = new bool[num];
        int minSum = int.MaxValue;

        for (int i = 0; i < num; i++)
        {
            int[] str = Console.ReadLine().Split(' ').Select(x => int.Parse(x)).ToArray();
            numList[i, 0] = str[0];
            numList[i, 1] = str[1];
        }

        void makeSub(int cnt)
        {
            if (cnt == num)
            {
                int sum = getSum();
                if (sum != int.MaxValue)
                {
                    minSum = Math.Min(minSum, sum);
                }
                return;
            }

            isSelected[cnt] = true;
            makeSub(cnt + 1);

            isSelected[cnt] = false;
            makeSub(cnt + 1);
        }

        int getSum()
        {
            int sourProduct = 1;
            int bitterSum = 0;
            bool selected = false;

            for (int j = 0; j < num; j++)
            {
                if (isSelected[j])
                {
                    sourProduct *= numList[j, 0];
                    bitterSum += numList[j, 1];
                    selected = true;
                }
            }

            if (!selected)
            {
                return int.MaxValue; // 재료를 하나도 사용하지 않은 경우 무시
            }

            return Math.Abs(sourProduct - bitterSum);
        }

        makeSub(0);
        Console.WriteLine(minSum);
    }
}