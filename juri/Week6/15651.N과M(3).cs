using System.Text;
namespace BOJ
{
    internal class Program
    {
        static void Main(string[] args)
        {
            int[] numbers = Console.ReadLine().Split(' ').Select(n => Convert.ToInt32(n)).ToArray();
            StringBuilder str = new StringBuilder();
            void makeNumber(string current, int nowLength)
            {
                if (nowLength == numbers[1])
                {
                    str.AppendLine(current);
                }
                else
                {
                    for (int i = 1; i <= numbers[0]; i++)
                    {
                        makeNumber(current + ' ' + i.ToString(), nowLength + 1);
                    }
                }
            }

            for (int i = 1; i <= numbers[0]; i++)
            {
                makeNumber(i.ToString(), 1);
            }
            Console.Write(str);
        }
    }
}
