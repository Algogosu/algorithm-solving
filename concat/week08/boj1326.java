// 패키지 선언 부분은 주석 처리되어 있음
// package boj1326;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // 입력을 받기 위한 BufferedReader 객체 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 첫 번째 줄에서 N 값을 읽어들임
        int N = Integer.parseInt(br.readLine());
        
        // 배열 A는 인덱스 1부터 N까지 사용하므로 크기를 N+1로 설정
        int[] A = new int[N+1];
        
        // 두 번째 줄에서 배열 A의 값을 읽어들임
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        
        // 세 번째 줄에서 시작점 a와 끝점 b를 읽어들임
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        
        // BFS를 사용하여 최소 점프 횟수를 계산하고 결과를 출력
        System.out.println(bfs(A, a, b, N));
        
        // BufferedReader 객체 닫기
        br.close();
    }
    
    // BFS를 이용하여 최소 점프 횟수를 찾는 함수
    public static int bfs(int[] A, int a, int b, int N) {
        // BFS를 위한 큐 생성, 각 원소는 [현재 위치, 점프 횟수] 형태
        Queue<int[]> queue = new LinkedList<>();
        
        // 방문 여부를 체크하기 위한 배열 생성
        boolean[] visited = new boolean[N+1];
        
        // 시작 지점 a와 점프 횟수 0을 큐에 추가하고 방문 체크
        queue.add(new int[]{a, 0});
        visited[a] = true; // 시작 지점 방문 체크
        
        // 큐가 빌 때까지 반복
        while (!queue.isEmpty()) {
            // 큐에서 현재 위치와 점프 횟수를 꺼냄
            int[] v = queue.poll();
            int current = v[0];
            int steps = v[1];
            
            // 현재 위치가 목표 위치 b인 경우 점프 횟수를 반환
            if (current == b) {
                return steps;
            }
            
            // 현재 위치에서 점프 가능한 모든 위치 탐색 (오른쪽 방향)
            for (int i = current + A[current]; i <= N; i += A[current]) {
                if (!visited[i]) {
                    queue.add(new int[]{i, steps + 1});
                    visited[i] = true;
                }
            }
            
            // 현재 위치에서 점프 가능한 모든 위치 탐색 (왼쪽 방향)
            for (int i = current - A[current]; i > 0; i -= A[current]) {
                if (!visited[i]) {
                    queue.add(new int[]{i, steps + 1});
                    visited[i] = true;
                }
            }
        }
        
        // 목표 위치 b에 도달할 수 없는 경우 -1 반환
        return -1;
    }
}
