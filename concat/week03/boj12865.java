//package boj12865;

/*
1. 각 물품의 무게와 가치를 입력받아 DP를 위한 메모이제이션 배열을 초기화합니다. 각 물품을 고려하여 배낭의 현재 무게에서 해당 물품을 추가할 수 있는지 확인합니다.
2. 각 물품을 배낭에 추가할 때와 추가하지 않을 때의 최대 가치를 비교하여 메모이제이션 배열을 갱신합니다. 점화식은 memo[j] = max(memo[j], memo[j - W[i]] + V[i])입니다.
3. 최종적으로 배낭의 최대 무게 K에서 얻을 수 있는 최대 가치를 메모이제이션 배열에서 찾아 출력합니다.
*/

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 물품의 수
        int K = Integer.parseInt(st.nextToken()); // 최대 배낭 무게
        // System.out.println(N + " " + K);
        
        int[] W = new int[N + 1]; // 물품의 무게
        int[] V = new int[N + 1]; // 물품의 가치
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());            
        }
        // System.out.println(Arrays.toString(W));
        // System.out.println(Arrays.toString(V));
        
        int[] memo = new int[K + 1]; // DP를 위한 메모이제이션 배열
        
        for (int i = 1; i <= N; i++) {
            // 물품 i를 고려할 때, 현재 배낭 무게에서 물품 i를 넣을 수 있는지 확인
            for (int j = K; j >= W[i]; j--) {
                // 점화식: memo[j] = max(memo[j], memo[j - W[i]] + V[i])
                memo[j] = Math.max(memo[j], memo[j - W[i]] + V[i]);
                // System.out.println(Arrays.toString(memo));
            }
        }
        bw.write(memo[K] + ""); // 최대 가치 출력
        bw.flush();
        br.close();
        bw.close();
    }
}
