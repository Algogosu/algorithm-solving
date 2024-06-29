public class Solution
{
    public int FindJudge(int n, int[][] trust)
    {
        int[] trustor = new int[n + 1];//믿음을 주는 사람
        int[] trustee = new int[n + 1];//믿음을 받는 사람
        int result = -1;
        foreach (int[] arr in trust)
        {
            //arr 의 0번째가 믿음 주는 사람
            //arr 의 1번째가 믿음 받는 사람
            //town judge 는 모두가 믿고 : trustee 값이 n-1
            //모두를 믿지않음 trustor 값이 0 
            trustor[arr[0]] = trustor[arr[0]] + 1;
            trustee[arr[1]] = trustee[arr[1]] + 1;
        }
        for (int i = 1; i < n + 1; i++)
        {
            if (trustor[i] == 0 && trustee[i] == n - 1)
            {
                if (result == -1) result = i;
                else return -1;
            }
        }
        return result;
    }
}