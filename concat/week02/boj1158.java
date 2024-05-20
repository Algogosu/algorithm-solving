// package boj1158;

import java.io.*;
import java.util.*;

/*
1. 사람의 수 N과 제거할 순번 K를 입력받고, 1부터 N까지의 수를 ArrayDeque에 추가하여 원형 순열을 초기화합니다.
2. 큐에서 사람을 하나씩 제거하면서, K번째 사람을 제거할 때마다 출력하고 제거한 사람의 수를 초기화합니다. K번째가 아닌 경우에는 제거한 사람을 다시 큐의 맨 뒤에 추가합니다.
3. 큐가 빌 때까지 반복하여 요세푸스 순열을 계산하고, 결과를 "<"과 ">" 사이에 출력합니다.
*/

public class Main {
    public static void main(String[] args) throws Exception {
        // 입력 파일에서 데이터 읽기 (테스트용)
        // System.setIn(new FileInputStream("src/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N과 K 입력받기
        // N: 사람의 수
        // K: 제거할 순번
        String[] tmp = br.readLine().split(" ");
        int N = Integer.parseInt(tmp[0]);
        int K = Integer.parseInt(tmp[1]);

        br.close();

        // 1부터 N까지의 수를 큐에 추가
        // 원형 순열을 처리하기 위해 ArrayDeque 사용
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        // 요세푸스 순열 계산
        int cnt = 0; // 현재까지 제거한 사람의 수

        // 결과 출력을 위한 BufferedWriter 생성
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write("<"); // 결과 시작을 나타내는 "<" 출력

        // 큐가 빌 때까지 반복
        while (!queue.isEmpty()) {
            int val = queue.poll(); // 큐에서 사람 제거

            // K번째 사람을 제거하고 출력
            if (++cnt == K) {
                bw.write(Integer.toString(val)); // 제거한 사람 출력
                cnt = 0; // 제거한 사람의 수 초기화

                // 큐가 비어있지 않으면 쉼표와 공백 출력
                if (!queue.isEmpty()) {
                    bw.write(", ");
                }
            } else {
                // K번째가 아닌 경우 큐의 맨 뒤에 다시 추가
                queue.add(val);
            }
        }

        bw.write(">"); // 결과 끝을 나타내는 ">" 출력
        bw.flush(); // 버퍼 비우기
        bw.close(); // BufferedWriter 닫기
    }
}