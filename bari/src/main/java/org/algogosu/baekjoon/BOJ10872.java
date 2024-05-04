package org.algogosu.baekjoon;

import java.io.*;

// 팩토리얼
public class BOJ10872 {
    // for문 사용
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        int result = 1;
        for (int i = 1; i <= num; i++) {
            result *= i;
        }
        bw.write(Integer.toString(result));
        bw.close();
    }

    // 재귀함수 사용
    public static void main2(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        bw.write(Integer.toString(factorial(num)));
        bw.close();
    }

    private static int factorial(int num) {
        if (num == 0) {
            return 1;
        }
        return num * factorial(num - 1);
    }
}
