import sys
import heapq

# 입력을 읽어오는 함수 설정
input = lambda: sys.stdin.readline().strip()
print = lambda x: sys.stdout.write(str(x) + "\n")

# 입력 파일 설정 (테스트용)
# sys.stdin = open('input.txt', 'r')

# 도시의 개수 N과 버스의 개수 M 입력 받기
N = int(input())
M = int(input())

# 그래프 초기화
graph = {}
for _ in range(M):
    a, b, c = map(int, input().split())
    if a not in graph:
        graph[a] = {}
    # 동일한 도착지에 대한 여러 버스 노선 중 최소 비용으로 저장
    graph[a][b] = min(c, graph[a].get(b, float('inf')))
# print(graph)  # 디버깅용, 필요시 활성화

# 출발 도시 A와 도착 도시 B 입력 받기
A, B = map(int, input().split())
# print((A, B))  # 디버깅용, 필요시 활성화

# 모든 도시의 최단 거리를 무한대로 초기화
distances = {node: float('inf') for node in range(1, N+1)}
# print(distances)  # 디버깅용, 필요시 활성화

# 출발 도시의 거리를 0으로 설정
distances[A] = 0

# 우선순위 큐를 이용한 다익스트라 알고리즘 초기화
pq = []
heapq.heappush(pq, (distances[A], A))

# 다익스트라 알고리즘 실행
while pq:
    cur_dist, cur_dest = heapq.heappop(pq)
    # 현재 거리 정보가 이미 처리된 거리 정보보다 크면 무시
    if distances[cur_dest] < cur_dist:
        continue
    # 현재 도시에서 갈 수 있는 모든 도시의 거리 정보 업데이트
    for new_dest, new_dist in graph.get(cur_dest, {}).items():
        # print((new_dest, new_dist))  # 디버깅용, 필요시 활성화
        distance = cur_dist + new_dist
        # 새로운 거리가 기존 거리보다 작으면 업데이트
        if distance < distances[new_dest]:
            distances[new_dest] = distance
            heapq.heappush(pq, (distance, new_dest))
    # print(pq)  # 디버깅용, 필요시 활성화
    # print(distances)  # 디버깅용, 필요시 활성화

# 도착 도시까지의 최단 거리 출력
print(distances[B])