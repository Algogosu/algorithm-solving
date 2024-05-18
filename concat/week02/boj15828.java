// package boj15828;

import java.io.*;
import java.util.*;

/*
1. 큐의 최대 크기 N을 입력받고, ArrayDeque를 사용하여 큐를 생성합니다.
2. 입력으로 주어지는 값에 따라 다음 작업을 수행합니다:
    - 0이 입력되면 큐에서 원소를 제거합니다.
    - -1이 입력되면 입력을 종료합니다.
    - 큐가 가득 차면 원소를 추가하지 않습니다.
    - 그 외의 경우, 큐에 원소를 추가합니다.
3. 입력 처리가 끝난 후, 큐가 비어있으면 "empty"를 출력하고, 그렇지 않으면 큐의 원소를 공백으로 구분하여 출력합니다.
*/

public class Main {
    public static void main(String[] args) throws Exception {
        // 입력 파일에서 데이터 읽기 (테스트용)
        // System.setIn(new FileInputStream("src/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 큐의 최대 크기 N 입력받기
        int N = Integer.parseInt(br.readLine());

        // 큐 생성
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        // 입력 처리
        while (true) {
            int val = Integer.parseInt(br.readLine());

            if (val == 0) {
                // 0이 입력되면 큐에서 원소 제거
                queue.poll();
                continue;
            }

            if (val == -1) {
                // -1이 입력되면 입력 종료
                break;
            }

            if (queue.size() == N) {
                // 큐가 가득 차면 원소 추가하지 않음
                continue;
            }

            // 큐에 원소 추가
            queue.add(val);
        }

        br.close();

        // 결과 출력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        if (queue.isEmpty()) {
            // 큐가 비어있으면 "empty" 출력
            bw.write("empty");
        } else {
            // 큐의 원소를 공백으로 구분하여 출력
            for (Integer el : queue) {
                bw.write(el + " ");
            }
        }

        bw.flush();
        bw.close();
    }
}