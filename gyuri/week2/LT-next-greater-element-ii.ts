function nextGreaterElements(nums: number[]): number[] {
  // O(n^2)
  //   const result = [];

  //   for (let i = 0; i < nums.length; i++) {
  //     for (let j = 0; j < nums.length; j++) {
  //       const idx = (i + j) % nums.length;
  //       if (nums[i] < nums[idx]) {
  //         result.push(nums[idx]);
  //         break;
  //       }
  //       if (j === nums.length - 1) {
  //         result.push(-1);
  //       }
  //     }
  //   }

  // O(n)
  const result = Array(nums.length).fill(-1);
  const stack = [];
  for (let i = 0; i < nums.length * 2; i++) {
    const num = nums[i % nums.length];
    while (stack.length && nums[stack[stack.length - 1]] < num) {
      result[stack.pop()] = num;
    }
    if (i < nums.length) {
      stack.push(i);
    }
  }

  return result;
}
