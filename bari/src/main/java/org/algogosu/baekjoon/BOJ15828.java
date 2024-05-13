package org.algogosu.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 라우터
public class BOJ15828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> q = new LinkedList<>();

        int N = Integer.parseInt(br.readLine());
        while (true) {
            int input = Integer.parseInt(br.readLine());
            // -1인 경우 종료
            if (input == -1) {
                break;
            }
            // 0인 경우 가장 먼저 들어온 패킷 삭제
            else if (input == 0) {
                q.poll();
            }
            // 큐의 패킷 개수가 N개 미만인 경우 패킷 추가
            else if (q.size() < N) {
                q.add(input);
            }
        }

        if (q.isEmpty()) {
            System.out.print("empty");
        } else {
            while (!q.isEmpty()) {
                System.out.print(q.poll() + " ");
            }
        }
    }
}
