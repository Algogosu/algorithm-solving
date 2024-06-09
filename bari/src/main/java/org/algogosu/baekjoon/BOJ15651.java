package org.algogosu.baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

// N과 M (3)
public class BOJ15651 {
    public static List<Integer> arr = new ArrayList<>();
    public static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out)); // bw 안쓰니까 시간초과남

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        backTracking(N, M, 0);
        bw.flush();
        bw.close();
    }

    public static void backTracking(int N, int M, int cnt) throws IOException {
        // M개 선택했으면 출력
        if (cnt == M) {
            for (Integer integer : arr) {
                bw.write(integer + " ");
            }
            bw.write("\n");
            return;
        }

        // 1부터 N까지 선택
        for (int i = 1; i <= N; i++) {
            // go
            arr.add(i);
            backTracking(N, M, cnt + 1);
            // back
            arr.remove(arr.size() - 1);
        }
    }
}
