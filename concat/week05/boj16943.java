// 패키지 선언 (생략 가능)
// package boj16943;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // 파일에서 입력을 받기 위해 표준 입력을 파일로 설정 (테스트 시 주석 처리 필요)
        // System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력값을 읽어와서 A와 B로 나눔
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        // A의 각 자리 수를 배열로 변환하여 카운트
        int[] visited = new int[10];
        for (char c : Integer.toString(A).toCharArray()) {
            visited[c - '0']++;
        }

        int length = Integer.toString(A).length(); // A의 자릿수 계산
        permutation(visited, 0, length, new int[length], B); // 순열 생성 시작
        bw.write(answer + "\n"); // 결과 출력

        br.close(); // BufferedReader 닫기
        bw.flush(); // BufferedWriter의 버퍼를 비움
        bw.close(); // BufferedWriter 닫기
    }

    public static int answer = -1; // 최대값 저장 변수 초기화

    // 순열 생성 함수
    public static void permutation(int[] visited, int depth, int target, int[] result, int limit) {
        if (depth == target) { // 모든 자릿수를 채운 경우
            int tmp = 0;
            for (int j = 0; j < result.length; j++) {
                tmp = tmp * 10 + result[j]; // 현재 순열로 구성된 숫자 생성
            }
            if (tmp < limit) { // B보다 작은 경우에만 최대값 갱신
                answer = Math.max(answer, tmp);
            }
            return;
        }
        for (int i = 0; i < 10; i++) {
            if (visited[i] == 0) { // 이미 사용한 숫자인 경우 건너뛰기
                continue;
            }
            if (depth == 0 && i == 0) { // 첫 자리수가 0인 경우 건너뛰기
                continue;
            }
            result[depth] = i; // 현재 자리에 숫자 설정
            visited[i]--; // 해당 숫자 사용 표시
            int tmp = 0;
            for (int j = 0; j <= depth; j++) {
                tmp = tmp * 10 + result[j]; // 현재까지의 숫자 계산
            }
            if (tmp < limit) { // 현재까지의 숫자가 B보다 작은 경우에만 재귀 호출
                permutation(visited, depth + 1, target, result, limit);
            }
            visited[i]++; // 숫자 사용 취소
        }
    }
}
