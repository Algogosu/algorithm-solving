public class Solution
{
    public string LongestCommonPrefix(string[] strs)
    {
        //먼저 가장 작은 길이의 string 을 찾는다. 
        string minStr = strs[0];
        int lengthOfStr = minStr.Length;
        StringBuilder target = new StringBuilder();
        int cnt = 0;
        foreach (string i in strs)
        {
            if (i.Length < lengthOfStr)
            {
                minStr = i;
                lengthOfStr = i.Length;
            }
        }

        while (lengthOfStr > -1)
        {
            if (lengthOfStr == 0) return "";
            cnt = 0;
            target.Clear();
            target.Append(minStr.Substring(0, lengthOfStr));
            foreach (string j in strs)
            {
                if (j.Substring(0, lengthOfStr) != target.ToString())
                {
                    lengthOfStr--;
                    break;
                }
                else cnt++;
            }
            if (cnt == strs.Length) break;
        }
        return target.ToString();
    }
}