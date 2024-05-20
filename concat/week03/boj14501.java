//package boj14501;

import java.io.*;
import java.util.*;

/*
1. 각 상담 날짜마다 상담을 할 경우와 하지 않을 경우의 최대 수익을 계산하여 메모이제이션 배열에 저장합니다.
2. `memo(i + T[i]) = max(memo(i + T[i]), memo(i) + P[i])`를 사용해 상담을 하는 경우의 최대 수익을 갱신합니다.
3. `memo(i + 1) = max(memo(i + 1), memo(i))`를 사용해 상담을 하지 않는 경우의 최대 수익을 갱신하여 최종 최대 수익을 구합니다.
*/

public class Main {

    public static void main(String[] args) throws Exception {
        // System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine()); // 상담할 수 있는 날의 수
        // System.out.println(N);
        int[] T = new int[N]; // 각 상담을 완료하는 데 걸리는 시간
        int[] P = new int[N]; // 각 상담을 완료했을 때 받을 수 있는 금액
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }
        // System.out.println(Arrays.toString(T));
        // System.out.println(Arrays.toString(P));
        
        // DP를 위한 메모이제이션 배열
        // memo[i]는 i일째까지 얻을 수 있는 최대 수익을 저장
        int[] memo = new int[N+1];
        
        for (int i = 0; i < N; i++) {
            // i일에 상담을 했을 때, 상담이 끝나는 날이 N일 이내일 경우
            if (i + T[i] <= N) {
                // i + T[i] 날에 상담을 마친다면, memo[i + T[i]] 값 갱신
                memo[i + T[i]] = Math.max(memo[i + T[i]], memo[i] + P[i]);
            }
            // i일에 상담을 하지 않을 경우의 값 갱신
            // 점화식: memo(i + 1) = max(memo(i + 1), memo(i))
            memo[i + 1] = Math.max(memo[i + 1], memo[i]);
        }
        // System.out.println(Arrays.toString(memo));
        
        // N일까지 얻을 수 있는 최대 수익 출력
        bw.write(memo[N] + "");
        br.close();
        bw.close();
    }
}
