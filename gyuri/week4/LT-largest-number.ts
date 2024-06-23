function largestNumber(nums: number[]): string {
  const strs = nums.map((num) => num.toString());
  strs.sort((a, b) => (b + a).localeCompare(a + b));
  if (strs[0] === "0") return "0";
  return strs.join("");
}
