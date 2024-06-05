public class Solution {	
	// 그래이 코드를 생성하는 함수입니다.
	public static List<Integer> grayCode(int n) {
		// 2^n 크기의 결과 배열을 초기화합니다.
		int size = 1 << n;
		int[] result = new int[size];

		// 그래이 코드 생성 알고리즘 (반복적 접근)
		for (int i = 0; i < size; i++) {
			// i번째 그래이 코드를 생성합니다.
			result[i] = i ^ (i >> 1);
		}

		// 결과 배열을 리스트로 변환하여 반환합니다.
		List<Integer> resultList = new ArrayList<>();
		for (int num : result) {
			resultList.add(num);
		}

		return resultList;
	}
}
