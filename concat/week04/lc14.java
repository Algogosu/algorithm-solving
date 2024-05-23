class Solution {
    public String longestCommonPrefix(String[] strs) {
        // 결과를 저장할 StringBuilder
        StringBuilder sb = new StringBuilder();
        char c = 0; // 비교할 문자를 저장할 변수

        // 최대 200글자까지 확인
        for (int i = 0; i < 200; i++) {
            for (int j = 0; j < strs.length; j++) {
                // 현재 문자열의 길이가 i보다 작으면 공통 접두사 종료
                if (strs[j].length() <= i) {
                    return sb.toString();
                }
                // 첫 번째 문자열의 i번째 문자를 c에 저장
                if (j == 0) {
                    c = strs[0].charAt(i);
                    continue;
                }
                // 다른 문자열의 i번째 문자가 c와 다르면 공통 접두사 종료
                if (strs[j].charAt(i) != c) {
                    return sb.toString();
                }
            }
            // 모든 문자열의 i번째 문자가 동일하면 sb에 추가
            sb.append(c);
        }
        // 결과 반환
        return sb.toString();
    }
}
