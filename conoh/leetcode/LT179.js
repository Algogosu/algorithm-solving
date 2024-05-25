function largestNumber(nums) {
  if (nums.length === 0) return "";

  // 숫자들을 문자열로 변환
  const strNums = nums.map(String);

  // 커스텀 비교 함수로 정렬
  strNums.sort((a, b) => (b + a).localeCompare(a + b));

  // 정렬된 문자열 배열을 합쳐서 결과 문자열을 생성
  const result = strNums.join("");

  // 결과가 0으로 시작하면 0을 반환
  return result[0] === "0" ? "0" : result;
}
