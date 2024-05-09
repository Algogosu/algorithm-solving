// package boj1158;

import java.io.*;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws Exception {
        // 입력 파일에서 데이터 읽기 (테스트용)
        // System.setIn(new FileInputStream("src/input.txt"));
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // N과 K 입력받기
        String[] tmp = br.readLine().split(" ");
        int N = Integer.parseInt(tmp[0]);
        int K = Integer.parseInt(tmp[1]);
        
        br.close();
        
        // 1부터 N까지의 수를 큐에 추가
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }
        
        // 요세푸스 순열 계산
        int cnt = 0;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write("<");
        
        while (!queue.isEmpty()) {
            int val = queue.poll();
            
            // K번째 사람을 제거하고 출력
            if (++cnt == K) {
                bw.write(Integer.toString(val));
                cnt = 0;
                
                // 큐가 비어있지 않으면 쉼표와 공백 출력
                if (!queue.isEmpty()) {
                    bw.write(", ");
                }
            } else {
                // K번째가 아닌 경우 큐의 맨 뒤에 다시 추가
                queue.add(val);
            }
        }
        
        bw.write(">");
        bw.flush();
        bw.close();
    }
}