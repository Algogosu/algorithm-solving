class Solution {
    public String gcdOfStrings(String str1, String str2) {
        // 문자열의 길이에 따라 a와 b를 결정합니다. 
        // 항상 a는 짧은 문자열, b는 긴 문자열이 되도록 합니다.
        String a = str1.length() < str2.length() ? str1 : str2;
        String b = str1.length() < str2.length() ? str2 : str1;
        String answer = "";

        // a의 길이만큼 반복합니다.
        for (int i = 1; i <= a.length(); i++) {
            // a와 b의 길이가 현재 i로 나누어 떨어지지 않으면 continue.
            if (a.length() % i != 0 || b.length() % i != 0) {
                continue;
            }
            // 현재 길이 i까지의 문자열 부분을 sep으로 설정합니다.
            String sep = a.substring(0, i);

            // a와 b를 sep을 기준으로 나누었을 때 배열의 길이가 0이면 sep이 두 문자열의 공약수임을 의미합니다.
            if (a.split(sep).length == 0 && b.split(sep).length == 0) {
                answer = sep; // 공약수로 sep을 설정합니다.
            }
        }
        return answer; // 최종 공약수 문자열을 반환합니다.
    }
}
