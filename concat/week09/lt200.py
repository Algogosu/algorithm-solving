class Solution:

    def numIslands(self, grid: List[List[str]]) -> int:
        rows = len(grid)  # 그리드의 행 개수
        cols = len(grid[0])  # 그리드의 열 개수
        size = rows * cols  # 전체 그리드의 크기
        parent = list(range(size))  # 각 노드의 부모를 자기 자신으로 초기화
        rank = [0] * size  # 랭크 배열 초기화
        self.count = size  # 초기 섬의 개수 (모든 셀을 개별적인 섬으로 간주)

        # find 함수: 노드의 루트 노드를 찾는 함수 (경로 압축 사용)
        def find(node):
            # 부모 노드가 자기 자신이 아니면, 루트 노드를 찾아 부모를 업데이트 (경로 압축)
            if parent[node] != node:
                parent[node] = find(parent[node])
            return parent[node]
        
        # union 함수: 두 노드를 같은 집합으로 합치는 함수 (랭크 기반 합치기 사용)
        def union(node1, node2):
            root1 = find(node1)
            root2 = find(node2)

            if root1 != root2:
                # 랭크를 기준으로 트리를 합침 (랭크 기반 합치기)
                # 랭크가 낮은 트리를 랭크가 높은 트리 아래에 붙임
                if rank[root1] > rank[root2]:
                    parent[root2] = root1
                elif rank[root1] < rank[root2]:
                    parent[root1] = root2
                else:
                    # 랭크가 같으면 한 쪽에 붙이고 그 쪽의 랭크를 증가시킴
                    parent[root2] = root1
                    rank[root1] += 1
                self.count -= 1  # 두 개의 집합이 하나로 합쳐졌으므로 섬의 개수를 감소

        # 그리드를 순회하며 유니언-파인드 알고리즘 적용
        for r in range(rows):
            for c in range(cols):
                if grid[r][c] == '1':
                    node = r * cols + c  # 현재 셀의 인덱스 계산
                    for dr, dc in [(1, 0), (0, 1)]:  # 아래와 오른쪽 셀을 검사
                        nr, nc = r + dr, c + dc
                        if nr < rows and nc < cols and grid[nr][nc] == '1':
                            union(node, nr * cols + nc)  # 현재 셀과 인접한 셀을 같은 집합으로 합침
                else:
                    self.count -= 1  # 물인 경우 초기 섬의 개수에서 제외

        return self.count  # 최종적으로 남은 섬의 개수를 반환
