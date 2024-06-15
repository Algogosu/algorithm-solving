package org.algogosu.baekjoon;

import java.io.*;

// 팔
public class BOJ1105 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        String[] input = br.readLine().split(" ");
        String L = input[0];
        String R = input[1];
        int result = 0;

        // L과 R의 길이가 다르면 0 출력
        if (L.length() != R.length()) {
            System.out.println(result);
            return;
        }

        // L과 R의 각 자리 비교
        for (int i = 0; i < L.length(); i++) {
            if (L.charAt(i) == R.charAt(i)) {
                if (L.charAt(i) == '8') {
                    result++;
                }
            } else {
                break;
            }
        }

        System.out.println(result);
    }
}
