const [n, ...arr] = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .split("\n");
const N = Number(n);
const counsel = arr.map((temp) => temp.split(" ").map(Number));

function solution(n, counsel) {
  // DP[i] = i일부터 마지막 날까지 상담을 했을 때 얻을 수 있는 최대 이익
  const DP = new Array(N + 2).fill(0);

  for (let i = N; i > 0; i--) {
    const [Ti, Pi] = counsel[i - 1];
    if (i + Ti > N + 1) DP[i] = DP[i + 1];
    else DP[i] = Math.max(DP[i + 1], Pi + DP[i + Ti]);
  }
  return DP[1];
}

console.log(solution(N, counsel));
