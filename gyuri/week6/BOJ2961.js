let [N, ...arr] = require("fs")
  .readFileSync("./input.txt")
  .toString()
  .trim()
  .split("\n");

function backtrack(ingredients, index, selected, results) {
  if (index === ingredients.length) {
    if (selected.length > 0) {
      results.push([...selected]);
    }
    return;
  }
  // 선택 안함
  backtrack(ingredients, index + 1, selected, results);
  // 선택
  selected.push(ingredients[index]);
  backtrack(ingredients, index + 1, selected, results);
  selected.pop();
}

function getMinDifference(combo) {
  let minVal = Infinity;

  combo.forEach((element) => {
    let sour = 1;
    let bitter = 0;
    element.forEach((ingredient) => {
      sour *= ingredient.sour;
      bitter += ingredient.bitter;
    });
    const difference = Math.abs(sour - bitter);
    if (difference < minVal) {
      minVal = difference;
    }
  });

  return minVal;
}

const ingredients = arr.map((str) => {
  let [sour, bitter] = str.split(" ").map(Number);
  return { sour, bitter };
});
let results = [];
backtrack(ingredients, 0, [], results);
console.log(getMinDifference(results));
