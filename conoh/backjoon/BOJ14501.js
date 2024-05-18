const fs = require("fs");

let input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

// 케챱고백: 백준 풀 때마다 이런 식으로 전역 변수의 입력값을 설정해줘야 한다는 사실이 잘 적응이 되지 않습니다 <<
// 이걸 안해줘서 틀렸다고 하다니 <<
const N = parseInt(input[0]);
const schedule = input.slice(1).map((line) => line.split(" ").map(Number));

function solution(N, schedule) {
  const dp = new Array(N + 1).fill(0);

  for (let i = 0; i < N; i++) {
    const [Ti, Pi] = schedule[i];

    if (i + 1 <= N) {
      dp[i + 1] = Math.max(dp[i + 1], dp[i]);
    }

    if (i + Ti <= N) {
      dp[i + Ti] = Math.max(dp[i + Ti], dp[i] + Pi);
    }
  }

  return Math.max(...dp);
}

const result = solution(N, schedule);
console.log(result);
