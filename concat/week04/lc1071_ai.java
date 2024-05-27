// AI 풀이

class Solution {
    public String gcdOfStrings(String str1, String str2) {
        // 만약 str1 + str2와 str2 + str1이 같지 않다면 공통 문자열이 없음
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        // str1과 str2의 길이의 최대 공약수를 구함
        int gcdLength = gcd(str1.length(), str2.length());
        // str1의 처음부터 최대 공약수 길이만큼 자른 부분 문자열이 공통 부분 문자열
        return str1.substring(0, gcdLength);
    }

    // 유클리드 호제법을 이용해 두 수의 최대 공약수를 구함
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
