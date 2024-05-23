import java.math.BigInteger;

class Solution {
    public String largestNumber(int[] nums) {
        // 정수 배열을 Integer 객체 배열로 변환
        Integer[] A = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            A[i] = nums[i];
        }

        // 커스텀 정렬: 두 숫자를 결합하여 비교
        Arrays.sort(A, (o1, o2) -> {
            String s1 = Integer.toString(o1);
            String s2 = Integer.toString(o2);
            return (new BigInteger(s2 + s1)).compareTo(new BigInteger(s1 + s2));
        });

        // 가장 큰 숫자가 0이면 0 반환
        if (A[0] == 0) {
            return "0";
        }

        // 정렬된 숫자를 문자열로 결합
        StringBuilder sb = new StringBuilder();
        for (int a : A) {
            sb.append(a);
        }

        // 결과 반환
        return sb.toString();     
    }
}
