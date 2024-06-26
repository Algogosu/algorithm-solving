class Solution {
    public boolean canJump(int[] nums) {
        // Set을 생성하여 이미 방문한 인덱스를 추적
        Set<Integer> set = new HashSet<>();
        // 깊이 우선 탐색(DFS) 시작, 시작 인덱스는 0
        return dfs(nums, set, 0);
    }

    public boolean dfs(int[] nums, Set<Integer> set, int depth) {
        // 현재 인덱스가 배열의 마지막 인덱스에 도달하면 true 반환
        if (depth == nums.length - 1) {
            return true;
        }
        // 현재 인덱스에서 이동할 수 있는 모든 범위를 탐색
        for (int i = 1; i <= nums[depth]; i++) {
            int nxt = depth + i; // 다음 인덱스 계산
            // 다음 인덱스를 이미 방문했는지 확인
            if (set.contains(nxt)) {
                continue; // 이미 방문했으면 다음 범위로 건너뜀
            } else {
                set.add(nxt); // 방문하지 않았으면 다음 인덱스를 Set에 추가
            }
            // 다음 인덱스에서 DFS를 재귀적으로 호출하여 마지막 인덱스에 도달할 수 있는지 확인
            if (dfs(nums, set, nxt)) {
                return true; // 도달할 수 있으면 true 반환
            }
        }
        return false; // 어떤 경로로도 마지막 인덱스에 도달할 수 없으면 false 반환
    }
}
