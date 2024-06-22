let input = require("fs").readFileSync("/dev/stdin").toString().split(" ");
let [N, M] = input;

const result = [];
const output = [];

function backtrack(depth) {
  if (depth == M) {
    result.push(output.join(" "));
    return;
  }

  for (let i = 1; i <= N; i++) {
    output.push(i);
    backtrack(depth + 1);
    output.pop();
  }
}

backtrack(0);

console.log(result.join("\n"));
