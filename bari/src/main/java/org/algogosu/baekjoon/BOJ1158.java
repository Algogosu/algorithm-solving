package org.algogosu.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// 요세푸스 문제
public class BOJ1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> arr = new ArrayList<>();

        // 입력
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        for (int i = 0; i < N; i++) {
            arr.add(i + 1);
        }

        int p = 0; // 포인터 index
        System.out.print("<");
        while(!arr.isEmpty()) {
            p = ((p + K - 1) % arr.size());
            System.out.print(arr.get(p));
            arr.remove(p);
            if (!arr.isEmpty()) {
                System.out.print(", ");
            }
        }
        System.out.print(">");
    }
}
