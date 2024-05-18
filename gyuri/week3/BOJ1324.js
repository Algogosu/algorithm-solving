const [n, first, second] = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n");
const N = Number(n);
const first_garbage = first.split(" ").map(Number);
const second_garbage = second.split(" ").map(Number);

function solution() {
  const DP = Array.from({ length: N + 1 }, () => Array(N + 1).fill(0));
  let lastPick = -1;
  for (let i = 1; i <= N; i++) {
    for (let j = 1; j <= N; j++) {
      if (first_garbage[i - 1] === second_garbage[j - 1])
        if (lastPick < second_garbage[j - 1]) {
          DP[i][j] = DP[i - 1][j - 1] + 1;
          lastPick = second_garbage[j - 1];
        }
      DP[i][j] = Math.max(DP[i][j], DP[i - 1][j], DP[i][j - 1]);
    }
  }
  return DP[N][N];
}

console.log(solution());
