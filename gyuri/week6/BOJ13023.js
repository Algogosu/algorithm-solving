let input = require("fs")
  .readFileSync("./input.txt")
  .toString()
  .trim()
  .split("\n");

const [N, M] = input[0].split(" ").map(Number);

// 그래프 생성
const graph = Array.from({ length: N }, () => []);
for (let i = 1; i <= M; i++) {
  const [a, b] = input[i].split(" ").map(Number);
  graph[a].push(b);
  graph[b].push(a);
}

// dfs로 깊이가 4인 연결을 찾음
let found = false;
function dfs(node, depth, visited) {
  if (depth === 4) {
    found = true;
    return;
  }
  visited[node] = true;
  for (const neighbor of graph[node]) {
    if (!visited[neighbor]) {
      dfs(neighbor, depth + 1, visited);
      if (found) return;
    }
  }
  visited[node] = false;
}

// 모든 노드에서 확인
for (let i = 0; i < N; i++) {
  const visited = Array(N).fill(false);
  dfs(i, 0, visited);
  if (found) break;
}

console.log(Number(found));
