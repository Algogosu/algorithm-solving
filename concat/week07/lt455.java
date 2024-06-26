class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g); // 아이들의 만족도 배열을 오름차순으로 정렬합니다.
        Arrays.sort(s); // 쿠키 크기 배열을 오름차순으로 정렬합니다.
        // System.out.println(Arrays.toString(g));
        // System.out.println(Arrays.toString(s));
        
        int i = 0; // 만족도를 확인할 현재 아이의 인덱스
        int j = 0; // 쿠키 크기를 확인할 현재 인덱스
        int answer = 0; // 만족한 아이들의 수를 카운트하는 변수
        
        // 아이들과 쿠키 배열 모두 끝에 도달하지 않았을 때 반복합니다.
        while (j < s.length && i < g.length) {
            // 현재 아이의 만족도가 현재 쿠키 크기보다 작거나 같으면
            if (g[i] <= s[j]) {
                i++; // 다음 아이로 넘어갑니다.
                answer++; // 만족한 아이의 수를 증가시킵니다.
            }
            j++; // 현재 쿠키가 만족하든 못하든 다음 쿠키로 넘어갑니다.
        }
        
        return answer; // 만족한 아이들의 총 수를 반환합니다.
    }
}
