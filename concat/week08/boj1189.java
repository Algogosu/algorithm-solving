// package boj1189; // 패키지 선언

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // System.setIn(new FileInputStream("src/input.txt")); // 파일 입력을 위한 코드 (주석 처리됨)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력을 받기 위한 BufferedReader
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력을 위한 BufferedWriter

        // 첫 번째 줄에서 R, C, K 값을 읽음
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken()); // 행의 수
        int C = Integer.parseInt(st.nextToken()); // 열의 수
        int K = Integer.parseInt(st.nextToken()); // 목표 거리
        
        // 입력된 R, C, K 값을 확인하기 위한 출력 (주석 처리됨)
        // System.out.println(R + " " + C + " " + K);
        
        // 그리드 정보를 저장할 2차원 배열
        String[][] grid = new String[R][C];
        for (int i = 0; i < R; i++) {
            grid[i] = br.readLine().split(""); // 각 행을 읽어와서 배열에 저장
        }
        
        // 그리드의 내용 확인을 위한 출력 (주석 처리됨)
        // System.out.println(Arrays.deepToString(grid));
        
        // 이동 방향을 나타내는 배열 (상하좌우)
        int[][] d = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        // 각 거리에 따른 경로의 수를 저장하는 배열
        int[] dist = new int[R * C + 1];
        
        // 방문 여부를 저장하는 배열
        boolean[][] visited = new boolean[R][C];
        
        // 시작점 (R-1, 0)을 방문 처리
        visited[R-1][0] = true;
        
        // DFS 탐색 시작
        dfs(d, grid, dist, visited, R-1, 0, 1, R, C);
        
        // 목표 거리 K에 해당하는 경로의 수를 출력
        bw.write(dist[K] + "");
        br.close();
        bw.close();
    }

    // 깊이 우선 탐색 (DFS) 함수
    public static void dfs(int[][] d, String[][] grid, int[] dist, boolean[][] visited, int r, int c, int depth, int R, int C) {
        // 도착지점에 도달했을 때
        if (r == 0 && c == C - 1) {
            dist[depth]++; // 현재 깊이(depth)에 해당하는 경로의 수 증가
            return;
        }
        // 상하좌우로 이동
        for (int[] dd : d) {
            int dr = dd[0]; // 행 방향 이동
            int dc = dd[1]; // 열 방향 이동
            int nr = r + dr; // 새로운 행 위치
            int nc = c + dc; // 새로운 열 위치
            // 새로운 위치가 유효하고, 방문하지 않았으며, 장애물('T')이 아닌 경우
            if (nr >= 0 && nr < R && nc >= 0 && nc < C && !visited[nr][nc] && !grid[nr][nc].equals("T")) {
                visited[nr][nc] = true; // 방문 처리
                dfs(d, grid, dist, visited, nr, nc, depth + 1, R, C); // 다음 위치로 DFS 재귀 호출
                visited[nr][nc] = false; // 재귀 호출 후 방문 처리 해제
            }
        }
    }
}
