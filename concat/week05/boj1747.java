// 패키지 선언 (생략 가능)
package boj1747;

import java.io.*;
// import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // 입력과 출력을 위한 BufferedReader와 BufferedWriter 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 첫 번째 줄에서 정수 N을 입력받음
        // System.out.println(N);

        // 소수 판별을 위한 boolean 배열 초기화 (범위는 2,000,000까지 설정)
        boolean[] prime = new boolean[2_000_001];
        prime[0] = true; // 0은 소수가 아님
        prime[1] = true; // 1은 소수가 아님
        // 에라토스테네스의 체를 이용하여 소수를 판별
        for (int i = 2; i < prime.length; i++) {
            if (prime[i]) {
                continue; // 이미 소수가 아닌 것으로 판별된 경우 건너뛰기
            }
            for (int j = i * 2; j < prime.length; j += i) {
                prime[j] = true; // i의 배수들은 소수가 아님
            }
        }
        // System.out.println(Arrays.toString(prime));

        // N 이상인 소수 중 회문인 첫 번째 수 찾기
        for (int i = N; i < prime.length; i++) {
            if (prime[i]) {
                continue; // 소수가 아닌 경우 건너뛰기
            }
            String tmp = Integer.toString(i); // 소수를 문자열로 변환하여 회문 체크
            boolean flag = false; // 회문 체크를 위한 플래그 변수 초기화
            for (int j = 0; j < tmp.length(); j++) {
                // 앞뒤 문자가 다를 경우 회문이 아님
                if (tmp.charAt(j) != tmp.charAt(tmp.length() - 1 - j)) {
                    flag = true;
                    break; // 다르면 반복문 종료
                }
            }
            if (!flag) {
                // 회문인 소수를 찾으면 결과 출력 후 종료
                bw.write(i + "");
                break;
            }
        }

        br.close(); // BufferedReader 닫기
        bw.flush(); // BufferedWriter의 버퍼를 비움
        bw.close(); // BufferedWriter 닫기
    }
}