let input = require("fs").readFileSync("/dev/stdin").toString().split("\n");

let bufferSize = input[0];
let fifo = [];

for (let i = 1; i < input.length; i++) {
  if (input[i] == -1) {
    break;
  }

  if (input[i] > 0) {
    if (fifo.length >= bufferSize) {
      continue;
    } else {
      fifo.push(input[i]);
    }
  } else {
    fifo.shift();
  }
}

console.log(fifo.length === 0 ? "empty" : fifo.join(" "));
