import sys
import heapq

input = lambda: sys.stdin.readline().strip()
print = lambda x: sys.stdout.write(str(x) + "\n")

# input 파일을 'input3.txt'로 설정 (테스트용)
# sys.stdin = open('input3.txt', 'r')

# N은 지름길의 개수, D는 고속도로의 길이
N, D = map(int, input().split())

# 인접 리스트를 딕셔너리로 초기화
adj = {}

# 각 지름길 정보를 입력 받아 처리
for _ in range(N):
    a, b, c = map(int, input().split())
    # 지름길의 끝이 고속도로의 길이보다 크면 무시
    if b > D:
        continue
    # 지름길이 유효한 경우 인접 리스트에 추가
    if c < b - a:
        if a not in adj:
            adj[a] = {}
        adj[a][b] = min(c, adj[a].get(b, b - a))

# print(adj)  # 디버깅용 코드, 필요시 활성화

# 모든 노드의 최단 거리를 무한대로 초기화
distances = {node: float('inf') for node in range(D+1)}
distances[0] = 0  # 시작점의 거리는 0으로 설정

# 우선순위 큐를 사용한 다익스트라 알고리즘 초기화
pq = []
heapq.heappush(pq, [distances[0], 0])

# 다익스트라 알고리즘 실행
while pq:
    cur_dist, cur_dest = heapq.heappop(pq)
    # 현재 거리 정보가 이미 처리된 거리 정보보다 크면 무시
    if distances[cur_dest] < cur_dist:
        continue
    # 현재 지점에서 갈 수 있는 모든 지점 업데이트
    for new_dest, new_dist in adj.get(cur_dest, {}).items():
        distance = cur_dist + new_dist
        if distance < distances[new_dest]:
            distances[new_dest] = distance
            heapq.heappush(pq, [distance, new_dest])
    # 한 칸 이동한 경우 업데이트
    distance = cur_dist + 1
    new_dest = cur_dest + 1
    if new_dest > D:
        continue
    if distance < distances[new_dest]:
        distances[new_dest] = distance
        heapq.heappush(pq, [distance, new_dest])

# print(distances)  # 디버깅용 코드, 필요시 활성화

# 최종 목적지까지의 최단 거리 출력
print(distances[D])
