public class Solution {	
	// 그래이 코드를 생성하는 함수입니다.
	public static List<Integer> grayCode(int n) {
		// 2^n의 값을 계산합니다.
		int N = 1 << n;
		// 방문 여부를 체크하기 위한 배열입니다.
		boolean[] visited = new boolean[N];
		// 첫 번째 노드는 항상 0입니다.
		visited[0] = true;
		// 결과를 저장할 리스트를 초기화합니다.
		List<Integer> tmp = new ArrayList<>();
		tmp.add(0);
		// DFS를 사용하여 그래이 코드를 생성합니다.
		return dfs(n, N, visited, tmp, 0, 0);
	}
	
	// DFS를 사용하여 그래이 코드를 생성하는 함수입니다.
	public static List<Integer> dfs(int n, int N, boolean[] visited, List<Integer> tmp, int node, int depth) {
		// 모든 노드를 방문했다면 결과 리스트를 반환합니다.
		if (N == depth + 1) {
			return tmp;
		}
		// 각 비트 위치를 변경하며 다음 노드를 탐색합니다.
		for (int i = 0; i < n; i++) {
			// 현재 노드에서 i번째 비트를 반전시킵니다.
			int v = node ^ (1 << i);
			// 이미 방문한 노드라면 건너뜁니다.
			if (visited[v]) continue;
			// 노드를 방문 처리하고 리스트에 추가합니다.
			visited[v] = true;
			tmp.add(v);
			// 재귀 호출을 통해 다음 깊이로 이동합니다.
			List<Integer> result = dfs(n, N, visited, tmp, v, depth + 1);
			// 결과가 비어있지 않으면 반환합니다.
			if (!result.isEmpty()) return result;
			// 방문 상태를 되돌리고 리스트에서 제거합니다.
			visited[v] = false;
		}
		// 모든 경로를 탐색해도 결과가 없으면 빈 리스트를 반환합니다.
		return new ArrayList<>();
	}
}
