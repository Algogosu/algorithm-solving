const fs = require("fs");

let input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

const N = parseInt(input[0]);
const day1 = input[1].split(" ").map(Number);
const day2 = input[2].split(" ").map(Number);

function solution(N, day1, day2) {
  const dp = new Array(N).fill(0);

  for (let i = 0; i < N; i++) {
    let maxLength = 0;
    for (let j = 0; j < N; j++) {
      if (day1[i] === day2[j]) {
        dp[j] = Math.max(dp[j], maxLength + 1);
      }
      if (day1[i] > day2[j]) {
        maxLength = Math.max(maxLength, dp[j]);
      }
    }
  }

  return Math.max(...dp);
}

const result = solution(N, day1, day2);
console.log(result);
