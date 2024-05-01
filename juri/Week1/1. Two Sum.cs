public class Solution {
    public int[] TwoSum(int[] nums, int target) {
        int s = 0;
        int[] result = new int[2] {0,0};

        for(; s < nums.Length ; s++)
        {
            //target - 현재값 의 결과값이 있는지 찾는다. 
            int sub = target - nums[s];
            //Array.IndexOf(배열, 비교문자, 비교시작할 index)
            //O(n^2) 보다 나은 방법 
            if(Array.IndexOf(nums, sub, s+1) > -1) 
            {
                result[0] = s;
                result[1] = Array.IndexOf(nums,sub, s+1);
            }
        }
        return result;
    }
}