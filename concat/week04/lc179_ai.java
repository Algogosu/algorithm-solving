import java.util.Arrays;

// AI가 개선한 풀이

class Solution {
    public String largestNumber(int[] nums) {
        // 정수 배열을 문자열 배열로 변환
        String[] numStrs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numStrs[i] = String.valueOf(nums[i]);
        }

        // 커스텀 정렬: 두 숫자를 결합하여 비교
        Arrays.sort(numStrs, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));

        // 가장 큰 숫자가 0이면 0 반환
        if (numStrs[0].equals("0")) {
            return "0";
        }

        // 정렬된 숫자를 문자열로 결합
        StringBuilder sb = new StringBuilder();
        for (String numStr : numStrs) {
            sb.append(numStr);
        }

        // 결과 반환
        return sb.toString();
    }
}