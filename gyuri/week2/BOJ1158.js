let input = require("fs").readFileSync("/dev/stdin").toString().split(" ");

let n = input[0];
let k = input[1] - 1;

let people = Array.from({ length: n }, (_, i) => i + 1);
let result = [];
let index = 0;

while (people.length > 0) {
  index = (index + k) % people.length;
  result.push(people[index]);
  people.splice(index, 1);
}

console.log("<" + result.join(", ") + ">");
