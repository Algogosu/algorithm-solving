let input = require("fs").readFileSync("/dev/stdin").toString().split("\n");

// factorial()은 계속해서 자기 자신을 호출함
function factorial(num) {
  // 0! = 1, 1! = 1이므로 예외 처리
  if (num === 0 || num === 1) {
    return 1;
  }

  return num * factorial(num - 1);
}

const result = factorial(input);
console.log(result);
