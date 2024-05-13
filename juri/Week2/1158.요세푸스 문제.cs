namespace BOJ
{
    internal class Program
    {
        static void Main(string[] args)
        {
            string[] inputs = Console.ReadLine().Split(' ');
            int N = int.Parse(inputs[0]); // 사람 수 
            int K = int.Parse(inputs[1]); // 순서
            List<int> result = new List<int>(); // 정답 넣기 위한 list
            Queue<int> queue = new Queue<int>(Enumerable.Range(1, N));

            int cnt = 1;
            //큐를 만들어 입력받은 K 숫자 단위로 Dequeue을 하자 
            //K 배수가 아닌 순번은 Enqueue 로 queue 에 다시 넣자 
            while (queue.Count > 0)
            {
                //K배수 순번이라면 result에 값 넣기
                if (cnt % K == 0) result.Add(queue.Dequeue());
                //아니라면 queue에 다시 넣기 
                else queue.Enqueue(queue.Dequeue());
                cnt++;
            }

            Console.WriteLine("<" + String.Join(", ", result.ToArray()) + ">");
        }
    }
}