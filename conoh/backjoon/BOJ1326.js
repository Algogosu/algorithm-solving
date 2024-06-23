const readline = require("readline");

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

function bfs(A, a, b, N) {
  const queue = [];
  const visited = Array(N + 1).fill(false);

  queue.push([a, 0]);
  visited[a] = true;

  while (queue.length > 0) {
    const [current, steps] = queue.shift();

    if (current === b) {
      return steps;
    }

    for (let i = current + A[current]; i <= N; i += A[current]) {
      if (!visited[i]) {
        queue.push([i, steps + 1]);
        visited[i] = true;
      }
    }

    for (let i = current - A[current]; i > 0; i -= A[current]) {
      if (!visited[i]) {
        queue.push([i, steps + 1]);
        visited[i] = true;
      }
    }
  }

  return -1;
}

const inputLines = [];
rl.on("line", (line) => {
  inputLines.push(line);
}).on("close", () => {
  const N = parseInt(inputLines[0]);
  const A = [0, ...inputLines[1].split(" ").map(Number)];
  const [a, b] = inputLines[2].split(" ").map(Number);

  console.log(bfs(A, a, b, N));
});
