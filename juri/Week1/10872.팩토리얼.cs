using System;
namespace BOJ
{
    internal class Program
    {
        static void Main(string[] args)
        {
            string input = Console.ReadLine();
            int result = 1;
            for (int i = Int32.Parse(input); i > 0; i--)
            {
                result *= i;
            }

            Console.WriteLine(result);
        }
    }
}