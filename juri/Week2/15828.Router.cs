namespace BOJ
{
    internal class Program
    {
        static void Main(string[] args)
        {
            //N : queue의 최대 저장 수
            int N = int.Parse(Console.ReadLine());
            Queue<string> queue = new Queue<string>();
            string element = String.Empty;
            while (true)
            {
                element = Console.ReadLine();
                if (element.Equals("-1"))
                {
                    string result = String.Join(' ', queue.ToArray());
                    Console.WriteLine(result.Length == 0 ? "empty" : result);
                    break;
                }

                //0이면 하나가 처리된 것. 제일 마지막에 들어온 것 먼저 빼주기
                if (element.Equals("0"))
                {
                    queue.Dequeue();
                }
                else
                {
                    //queue의 count 가 n과 같으면 더이상 들어가지못함. 
                    //queue의 count 가 n보다 작을때만 넣어주기 
                    if (queue.Count < N) queue.Enqueue(element.ToString());
                }
            }
        }
    }
}