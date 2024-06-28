package org.algogosu.leetcode;

// Jump Game
public class LT55 {
    // 내가 푼 것
    public boolean canJump1(int[] nums) {
        // 방문 여부를 저장할 배열
        boolean[] visited = new boolean[nums.length];
        visited[0] = true;
        for (int i = 0; i < nums.length - 1; i++) {
            // 방문하지 않은 경우는 건너뛰기
            if (visited[i] == false) {
                continue;
            }
            // 현재 위치에서 갈 수 있는 위치를 방문
            for (int j = 1; j <= nums[i]; j++) {
                if (i + j >= nums.length) {
                    break;
                }
                visited[i + j] = true;
            }
        }
        // 마지막 위치까지 방문했는지 여부를 반환
        return visited[nums.length - 1];
    }

    // GPT가 풀어준 코드
    public boolean canJump2(int[] nums) {
        int maxReach = 0; // 현재까지 도달할 수 있는 최대 인덱스
        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) {
                return false; // 현재 위치에 도달할 수 없음
            }
            maxReach = Math.max(maxReach, i + nums[i]); // 최대 점프 거리 업데이트
            if (maxReach >= nums.length - 1) {
                return true; // 마지막 인덱스에 도달할 수 있음
            }
        }
        return false; // 마지막 인덱스에 도달할 수 없음
    }
}
