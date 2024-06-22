// package boj15651;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("src/input.txt"));

		// 표준 입력을 통해 데이터를 입력받기 위한 BufferedReader와 BufferedWriter 생성
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 첫 번째 줄에서 N과 M 값을 읽음
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 1부터 N까지의 숫자
		int M = Integer.parseInt(st.nextToken()); // 선택할 숫자의 개수

		// 순열을 저장할 배열
		int[] seq = new int[M];
		StringBuilder sb = new StringBuilder();

		// 백트래킹 함수 호출
		recursion(N, M, seq, 0, sb, bw);

		// 자원 해제
		br.close();
		bw.flush();
		bw.close();
	}

	// 백트래킹을 이용한 순열 생성 함수
	public static void recursion(int N, int M, int[] seq, int depth, StringBuilder sb, BufferedWriter bw) throws IOException {
		// 기저 조건: depth가 M에 도달하면 현재 순열을 출력
		if (depth == M) {
			for (int i : seq) {
				sb.append(i).append(" "); // 순열의 숫자를 StringBuilder에 추가
			}
			sb.append("\n"); // 한 줄의 끝
			bw.write(sb.toString()); // StringBuilder의 내용을 BufferedWriter로 출력
			sb.setLength(0); // StringBuilder 초기화
			return;
		}

		// 1부터 N까지의 숫자를 선택하여 순열 생성
		for (int i = 1; i <= N; i++) {
			seq[depth] = i; // 현재 깊이의 위치에 숫자 저장
			recursion(N, M, seq, depth + 1, sb, bw); // 다음 깊이로 재귀 호출
		}
	}
}

