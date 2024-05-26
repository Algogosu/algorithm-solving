package org.algogosu.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

// 서로 다른 부분 문자열의 개수
public class BOJ11478 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        HashSet<String> result = new HashSet<>(); // 중복 제거를 위한 Set

        for(int i = 0; i < S.length(); i++) { // 부분 문자열 시작 위치
            for(int j = i + 1; j <= S.length(); j++) { // 부분 문자열 끝 위치
                String sub = S.substring(i, j); // 부분 문자열
                result.add(sub);
            }
        }

        System.out.println(result.size());
    }
}
