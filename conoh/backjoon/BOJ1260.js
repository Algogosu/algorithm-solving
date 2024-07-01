const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

const [N, M, V] = input[0].split(" ").map(Number);
const edges = input.slice(1).map((line) => line.split(" ").map(Number));

// 인접 리스트 생성
const graph = Array.from({ length: N + 1 }, () => []);
for (const [a, b] of edges) {
  graph[a].push(b);
  graph[b].push(a);
}

// 정점 번호가 작은 것을 먼저 방문해야 하므로 정렬
for (let i = 1; i <= N; i++) {
  graph[i].sort((a, b) => a - b);
}

// DFS 구현
function dfs(graph, start) {
  const visited = Array(N + 1).fill(false);
  const result = [];

  function dfsUtil(v) {
    if (visited[v]) return;
    visited[v] = true;
    result.push(v);
    for (const neighbor of graph[v]) {
      if (!visited[neighbor]) {
        dfsUtil(neighbor);
      }
    }
  }

  dfsUtil(start);
  return result;
}

// BFS 구현
function bfs(graph, start) {
  const visited = Array(N + 1).fill(false);
  const result = [];
  const queue = [start];
  visited[start] = true;

  while (queue.length > 0) {
    const v = queue.shift();
    result.push(v);
    for (const neighbor of graph[v]) {
      if (!visited[neighbor]) {
        visited[neighbor] = true;
        queue.push(neighbor);
      }
    }
  }

  return result;
}

const dfsResult = dfs(graph, V);
const bfsResult = bfs(graph, V);

console.log(dfsResult.join(" "));
console.log(bfsResult.join(" "));
