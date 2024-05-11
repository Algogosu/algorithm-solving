// package boj10872;

import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // 입력 파일에서 읽어오는 경우 (테스트용)
        // System.setIn(new FileInputStream("src/input.txt"));
        
        // 표준 입력에서 정수 N을 읽어옴
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        br.close();
        
        // 반복문을 이용한 팩토리얼 계산 (주석 처리됨)
        // int result = iteration(N);
        
        // 재귀를 이용한 팩토리얼 계산 (사용 중)
        int result = recursion(N);
        
        // DP를 이용한 팩토리얼 계산 (주석 처리됨)
        // int result = dp(N);
        
        // 결과 출력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();
    }
    
    // DP(동적 계획법)를 이용한 팩토리얼 계산 함수
    // 이전 계산 결과를 메모이제이션하여 중복 계산을 피함
    public static int dp(int n) {
        int[] memo = new int[13]; // 0부터 12까지의 팩토리얼 값을 저장할 배열
        memo[0] = 1; // 0!은 1로 초기화
        memo[1] = 1; // 1!은 1로 초기화
        
        // 2부터 n까지 반복하며 팩토리얼 계산
        for (int i = 2; i < memo.length; i++) {
            memo[i] = memo[i-1] * i; // i!은 (i-1)! * i로 계산
        }
        
        return memo[n]; // n!의 값을 반환
    }
    
    // 재귀를 이용한 팩토리얼 계산 함수
    public static int recursion(int n) {
        // 기저 사례: 0!과 1!은 1
        if (n == 0 || n == 1) {
            return 1;
        }
        
        // 재귀 호출을 통해 팩토리얼 계산
        return n * recursion(n - 1);
    }
    
    // 반복문을 이용한 팩토리얼 계산 함수
    public static int iteration(int n) {
        // 0!은 1로 초기화
        if (n == 0) {
            return 1;
        }
        
        int result = 1; // 팩토리얼 계산 결과를 저장할 변수
        
        // 2부터 n까지 반복하며 팩토리얼 계산
        for (int i = 2; i <= n; i++) {
            result *= i; // result에 i를 곱해나감
        }
        
        return result; // n!의 값을 반환
    }
}