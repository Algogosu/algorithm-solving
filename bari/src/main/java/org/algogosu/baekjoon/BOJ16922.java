package org.algogosu.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

// 로마 숫자 만들기 (시간초과..)
public class BOJ16922 {
    public static HashSet set = new HashSet();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 사용할 수 있는 문자의 개수
        int[] numbers = {1, 5, 10, 50};

        combination(numbers, N, 0, 0);

        System.out.println(set.size());
    }

    // 백트래킹, 중복조합 구하기
    public static void combination(int[] numbers, int n, int sum, int cnt) {
        if (cnt == n) {
            set.add(sum);
            return;
        }
        for (int i = 0; i < numbers.length; i++) {
            combination(numbers, n, sum + numbers[i], cnt + 1);
        }
    }
}