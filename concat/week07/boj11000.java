import java.io.*;  // 입출력 관련 클래스 사용
import java.util.*;  // 유틸리티 클래스 사용 (예: Scanner, PriorityQueue, Arrays 등)

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);  // 사용자 입력을 받기 위한 Scanner 객체 생성
        int N = scanner.nextInt();  // 강의 개수를 입력받음
        scanner.nextLine();  // 남아있는 개행 문자를 처리하기 위해 사용
        int[][] arr = new int[N][2];  // 강의의 시작 시간과 종료 시간을 저장할 2차원 배열 생성

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(scanner.nextLine());  // 한 줄씩 읽어와서 공백을 기준으로 분리
            int S = Integer.parseInt(st.nextToken());  // 시작 시간
            int T = Integer.parseInt(st.nextToken());  // 종료 시간
            arr[i] = new int[] {S, T};  // 배열에 시작 시간과 종료 시간을 저장
        }

        // 시작 시간을 기준으로 배열 정렬
        Arrays.sort(arr, (o1, o2) -> o1[0] - o2[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();  // 종료 시간을 저장할 우선순위 큐 생성
        pq.offer(arr[0][1]);  // 첫 번째 강의의 종료 시간을 큐에 추가

        for (int i = 1; i < N; i++) {  // 두 번째 강의부터 마지막 강의까지 반복
            if (arr[i][0] >= pq.peek()) {  // 현재 강의의 시작 시간이 가장 빨리 끝나는 강의의 종료 시간보다 크거나 같으면
                pq.poll();  // 큐에서 종료 시간을 제거
            }
            pq.offer(arr[i][1]);  // 현재 강의의 종료 시간을 큐에 추가
        }

        // 우선순위 큐의 크기를 출력 (필요한 강의실의 최소 개수)
        System.out.println(pq.size());
    }
}
