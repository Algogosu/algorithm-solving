const [L, R] = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split(" ")
  .map(Number);

function countMinimumEights(L, R) {
  L = L.toString();
  R = R.toString();

  if (L.length !== R.length) {
    return 0;
  }

  let countEights = 0;
  let length = L.length;

  for (let i = 0; i < length; i++) {
    if (L[i] !== R[i]) {
      break;
    }
    if (L[i] === "8") {
      countEights++;
    }
  }

  return countEights;
}

console.log(countMinimumEights(L, R));
