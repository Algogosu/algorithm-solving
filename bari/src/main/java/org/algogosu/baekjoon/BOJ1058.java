package org.algogosu.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 친구
public class BOJ1058 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] friends = new int[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                friends[i][j] = line.charAt(j) == 'Y' ? 1 : 0;
            }
        }

        int result = 0;
        // i번째 사람이 친구가 몇 명인지 확인
        for (int i = 0; i < N; i++) {
            int count = 0;
            // i번째 사람과 j번째 사람이 친구인 경우
            for (int j = 0; j < N; j++) {
                // i, j가 같은 경우 본인이므로 패스
                if (i == j) {
                    continue;
                }
                // i번째 사람과 j번째 사람이 친구인 경우
                if (friends[i][j] == 1) {
                    count++;
                } else {
                    // i번째 사람과 j번째 사람의 공통 친구가 있는지 확인
                    for (int k = 0; k < N; k++) {
                        if (friends[i][k] == 1 && friends[j][k] == 1) {
                            count++;
                            break;
                        }
                    }
                }
            }
            result = Math.max(result, count);
        }
        System.out.println(result);
    }
}
