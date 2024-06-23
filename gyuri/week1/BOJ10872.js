let input = require("fs").readFileSync("/dev/stdin").toString();

let output = 1;
for (let i = input; i > 0; i--) {
  output *= i;
}

console.log(output);
