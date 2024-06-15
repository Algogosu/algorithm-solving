const fs = require("fs");

let input = fs.readFileSync("/dev/stdin").toString().trim();

function solution(S) {
  const substrings = new Set();

  for (let i = 0; i < S.length; i++) {
    let substring = "";
    for (let j = i; j < S.length; j++) {
      substring += S[j];
      substrings.add(substring);
    }
  }

  return substrings.size;
}

const result = solution(input);
console.log(result);
