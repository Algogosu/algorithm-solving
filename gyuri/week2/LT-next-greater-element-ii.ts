function nextGreaterElements(nums: number[]): number[] {
  // O(n^2)
  const result = [];

  for (let i = 0; i < nums.length; i++) {
    for (let j = 0; j < nums.length; j++) {
      const idx = (i + j) % nums.length;
      if (nums[i] < nums[idx]) {
        result.push(nums[idx]);
        break;
      }
      if (j === nums.length - 1) {
        result.push(-1);
      }
    }
  }

  return result;
}
