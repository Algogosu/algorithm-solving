using System.Collections;

namespace BOJ
{
    internal class Program
    {
        static void Main(string[] args)
        {
            string str = Console.ReadLine();
            int s = 0;
            int e = 0;

            Hashtable list = new Hashtable();
            //투포인터 사용
            while (s < str.Length - 1)
            {
                if (e == str.Length)
                {
                    s++;
                    e = s;
                }
                //HashTable 에 값이 없을때만 ADD 해준다.
                if (!list.Contains(str.Substring(s, e - s + 1)))
                {
                    list.Add(str.Substring(s, e - s + 1), "");
                }
                e++;
            }
            Console.WriteLine(list.Count);
        }
    }
}
