// 패키지 선언 (생략 가능)
// package boj1058;

import java.io.*; // 입출력 라이브러리 임포트

public class Main {
    public static void main(String[] args) throws Exception {
        // 표준 입력을 받기 위한 BufferedReader와 표준 출력을 위한 BufferedWriter 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 첫 번째 줄에서 친구 관계의 수 N을 입력받음

        // 친구 관계를 저장할 2차원 boolean 배열 초기화
        boolean[][] adj = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String tmp = br.readLine(); // 각 행의 친구 관계를 문자열로 입력받음
            for (int j = 0; j < N; j++) {
                if (tmp.charAt(j) == 'Y') { // 'Y'일 경우 true로 설정
                    adj[i][j] = true;
                }
            }
        }

        int answer = 0; // 최대 친구 수를 저장할 변수 초기화
        for (int i = 0; i < N; i++) {
            int count = search(N, adj, i); // 각 사람마다 친구 수를 계산
            answer = Math.max(answer, count); // 최대 친구 수 갱신
        }
        bw.write(answer + ""); // 결과 출력

        br.close(); // BufferedReader 닫기
        bw.flush(); // BufferedWriter의 버퍼를 비움
        bw.close(); // BufferedWriter 닫기
    }

    // 주어진 사람 i의 2-친구 수를 계산하는 함수
    public static int search(int N, boolean[][] adj, int i) {
        int count = 0; // 친구 수를 세기 위한 변수
        for (int j = 0; j < N; j++) {
            if (i == j) { // 자기 자신은 건너뛰기
                continue;
            }
            if (adj[i][j]) { // 직접 친구인 경우
                count++;
            } else {
                for (int k = 0; k < N; k++) { // 간접 친구 여부 확인
                    if (adj[j][k] && adj[k][i]) { // j와 k가 친구이고, k와 i가 친구인 경우
                        count++;
                        break; // 한 번 확인했으면 더 이상 확인할 필요 없음
                    }
                }
            }
        }
        return count; // 친구 수 반환
    }
}