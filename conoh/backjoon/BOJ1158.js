let input = require("fs").readFileSync("/dev/stdin").toString().split(" ");

function solution(N, K) {
  const result = [];
  const people = Array.from({ length: N }, (_, index) => index + 1); // 1부터 N까지의 숫자로 배열 초기화
  let index = 0;

  while (people.length > 0) {
    index = (index + K - 1) % people.length; // K번째 사람의 인덱스 계산
    result.push(people.splice(index, 1)[0]); // K번째 사람을 배열에서 제거하고 결과 배열에 추가
  }

  return `<${result.join(", ")}>`; // 결과 배열을 문자열로 변환하여 반환
}

const N = parseInt(input[0]);
const K = parseInt(input[1]);
const result = solution(N, K);
console.log(result);
