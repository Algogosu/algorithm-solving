const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

const [N, D] = input[0].split(" ").map(Number);
const shortcuts = input.slice(1).map((line) => line.split(" ").map(Number));

// 다익스트라 알고리즘을 사용하여 최단 거리를 구합니다.
function findShortestPath(N, D, shortcuts) {
  // 최단 거리 배열을 무한대로 초기화
  const dist = Array(D + 1).fill(Infinity);
  dist[0] = 0; // 시작점 0의 거리는 0

  // 모든 거리에 대해 최소 거리를 계산
  for (let i = 0; i <= D; i++) {
    if (i > 0) {
      dist[i] = Math.min(dist[i], dist[i - 1] + 1);
    }
    for (const [start, end, length] of shortcuts) {
      if (start === i && end <= D && dist[start] + length < dist[end]) {
        dist[end] = dist[start] + length;
      }
    }
  }

  return dist[D];
}

const result = findShortestPath(N, D, shortcuts);
console.log(result);
