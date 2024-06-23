namespace BOJ
{
    internal class Program
    {
        static int maxVal = -1;
        static int B;
        static void Main()
        {
            string A = Console.ReadLine();
            B = int.Parse(Console.ReadLine());
            Permute(A.ToCharArray(), 0, A.Length - 1);
            Console.WriteLine(maxVal);
        }

        static void Swap(ref char a, ref char b)
        {
            char temp = a;
            a = b;
            b = temp;
        }

        static void Permute(char[] a, int l, int r)
        {
            if (l == r)
            {
                int num = int.Parse(new string(a));
                if (num < B && num > maxVal && a[0] != '0')
                {
                    maxVal = num;
                }
            }
            else
            {
                for (int i = l; i <= r; i++)
                {
                    Swap(ref a[l], ref a[i]);
                    Permute(a, l + 1, r);
                    Swap(ref a[l], ref a[i]);
                }
            }
        }
    }
}
