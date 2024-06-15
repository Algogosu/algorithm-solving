const fs = require("fs");

let input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");
let S = input[0];
let T = input[1];

function solution(S, T) {
  while (T.length > S.length) {
    if (T[T.length - 1] === "A") {
      T = T.slice(0, -1);
    } else if (T[T.length - 1] === "B") {
      T = T.slice(0, -1);
      T = T.split("").reverse().join("");
    }
  }

  return T === S ? 1 : 0;
}

const result = solution(S, T);
console.log(result);
