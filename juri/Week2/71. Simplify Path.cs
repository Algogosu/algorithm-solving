public class Solution
{
    public string SimplifyPath(string path)
    {
        //먼저 /로 분리해서 string array 생성
        //분리한 후 stack 에 넣고 .. 값일때 pop 해주면 됨
        string[] splited = path.Split('/');
        Stack<string> stack = new Stack<string>();
        StringBuilder result = new StringBuilder();
        foreach (string i in splited)
        {
            if (i.Equals(".."))
            {
                // 값이 .. 면서 stack에 값이 있으면 뒤로가기 = pop
                if (stack.Count > 0) stack.Pop();
            }
            //값이 없거나 . 이면 현재디렉토리 유지. 
            else if (String.IsNullOrEmpty(i) || i.Equals(".")) continue;
            else stack.Push("/" + i);
        }

        while (stack.Count > 0)
        {
            result.Insert(0, stack.Pop());
        }
        //stack 에 값이 하나도 없을때 예외처리
        return result.ToString().Length > 0 ? result.ToString() : "/";
    }
}