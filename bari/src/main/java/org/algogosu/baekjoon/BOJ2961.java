package org.algogosu.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 도영이가 만든 맛있는 음식
public class BOJ2961 {
    public static int[][] arr = new int[11][2]; // 0: 신맛, 1: 쓴맛
    public static boolean[] visited = new boolean[11]; // 음식 선택 여부
    public static int minValue = 1000000000; // 결과값

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int s = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            arr[i][0] = s;
            arr[i][1] = b;
        }

        backTracking(N, 0);

        System.out.println(minValue);
    }

    public static void backTracking(int N, int cnt) {
        if (cnt > 0) {
            // 신맛, 쓴맛 계산
            int sour = 1;
            int bitter = 0;
            for (int i = 0; i < N; i++) {
                if (visited[i]) {
                    sour *= arr[i][0];
                    bitter += arr[i][1];
                }
            }
            // 최소값 갱신
            minValue = Math.min(minValue, Math.abs(sour - bitter));
        }

        for (int i = 0; i < N; i++) {
            // 선택하지 않은 음식만 선택
            if (!visited[i]) {
                visited[i] = true;
                backTracking(N, cnt + 1);
                visited[i] = false;
            }
        }
    }
}
