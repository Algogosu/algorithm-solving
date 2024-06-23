const [nk, ...arr] = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n");
const N = Number(nk.split(" ")[0]);
const K = Number(nk.split(" ")[1]);
const beg = arr.map((t) => t.split(" ").map(Number));

function solution() {
  let DP = Array.from({ length: N + 1 }, () => Array(K + 1).fill(0));

  for (let i = 1; i <= N; i++) {
    const [weight, value] = beg[i - 1];
    for (let w = 0; w <= K; w++) {
      if (w < weight) DP[i][w] = DP[i - 1][w];
      else DP[i][w] = Math.max(DP[i - 1][w], value + DP[i - 1][w - weight]);
    }
  }
  return DP[N][K];
}

console.log(solution());
