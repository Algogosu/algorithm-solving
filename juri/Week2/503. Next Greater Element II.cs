public class Solution {
    public int[] NextGreaterElements(int[] nums) {
        Stack<int> stack = new Stack<int>();
        int[] results = new int[nums.Length];
        // 뒤에서부터 차례로 stack 에 넣어줌
        for (int i = nums.Length - 2 ; i>=0 ; i--)
        {
            stack.Push(nums[i]);
        }

        for (int j = nums.Length - 1 ; j >= 0 ; j--)
        {
            // 스택 최상단 요소가 현재값보다 작거나 같다면 pop
            while(stack.Count > 0 && stack.Peek() <= nums[j])
            {
                stack.Pop();
            }
            // 만약 스택에 남은 요소가 없다면 현재 요소보다 큰 값이 없다는 뜻.
            // -1 삽입
            if(stack.Count == 0) results[j] = -1;
            // 남은요소가있다면 최상단 요소 results 에 넣어주기 
            else results[j] = stack.Peek();

            //남은 연산을 위해서 현재값 다시 넣어주기
            stack.Push(nums[j]); 
        }

        return results;
    }
}