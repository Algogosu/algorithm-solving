// package boj13023;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		// 표준 입력을 파일 입력으로 대체 (테스트용)
		// System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 첫 줄에서 N (노드 수)와 M (간선 수)를 읽어들임
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// 인접 리스트를 사용하여 그래프를 표현
		List<Integer>[] adj = new ArrayList[N];
		for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList<>();
        }
		
		// 간선 정보를 읽어와 그래프를 구성
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj[a].add(b);
			adj[b].add(a);
		}

		// 방문 여부를 확인하는 배열
		boolean[] visited = new boolean[N];
		boolean found = false; // A-B-C-D-E 관계를 찾았는지 여부
		
		// 각 노드를 시작점으로 DFS 수행
		for (int i = 0; i < N; i++) {
			if (dfs(N, adj, visited, i, 0)) { // DFS 수행
				found = true; // 찾았으면 found를 true로 설정
				break; // 더 이상 탐색할 필요 없음
			}
		}

		// 결과 출력 (A-B-C-D-E 관계가 있으면 1, 없으면 0)
		bw.write((found ? 1 : 0) + "");
		bw.flush();
		br.close();
		bw.close();
		return;
	}
	
	// DFS를 통해 A-B-C-D-E 관계를 찾는 함수
	public static boolean dfs(int N, List<Integer>[] adj, boolean[] visited, int node, int depth) {
		// 깊이가 4이면 A-B-C-D-E 관계를 찾은 것이므로 true 반환
		if (depth == 4) {
			return true;
		}

		visited[node] = true; // 현재 노드를 방문으로 표시
		for (int neighbor : adj[node]) { // 인접 노드들을 순회
			if (!visited[neighbor]) { // 방문하지 않은 노드에 대해서
				if (dfs(N, adj, visited, neighbor, depth + 1)) { // DFS 재귀 호출
					return true; // A-B-C-D-E 관계를 찾으면 true 반환
				}
			}
		}
		visited[node] = false; // 백트래킹 (다시 방문 표시를 해제)
		return false; // 관계를 찾지 못했으면 false 반환
	}
}
