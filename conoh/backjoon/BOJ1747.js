const fs = require("fs");

let input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

const N = parseInt(input[0]);

function solution(N) {
  function isPrimeAndPalindrome(n) {
    if (n <= 1) return false;

    const str = n.toString();
    if (str !== str.split("").reverse().join("")) return false;

    if (n <= 3) return true;
    if (n % 2 === 0 || n % 3 === 0) return false;
    for (let i = 5; i * i <= n; i += 6) {
      if (n % i === 0 || n % (i + 2) === 0) return false;
    }
    return true;
  }

  while (true) {
    if (isPrimeAndPalindrome(N)) return N;
    N++;
  }
}

const result = solution(N);
console.log(result);
