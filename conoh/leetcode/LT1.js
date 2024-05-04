// 정수 배열 nums와 정수 target이 주어졌을 때, 두 숫자의 합이 target이 되는 인덱스를 반환합니다.
// 각 입력에는 정확히 하나의 해결책이 있다고 가정하며, 동일한 요소를 두 번 사용할 수 없습니다.
// 결과는 어떤 순서로든 반환할 수 있습니다.

// 1. 이중 for문으로 풀기
var twoSum = function (nums, target) {
  for (let i = 0; i < nums.length - 1; i++) {
    for (let j = i + 1; j < nums.length; j++) {
      if (target === nums[i] + nums[j]) return [i, j];
    }
  }
};

// 2. 해시맵을 사용해서 풀기

// 이 문제는 두 수의 합이 주어진 목표값과 같은 인덱스를 반환하는 것입니다.
// O(n^2) 시간 복잡도보다 빠른 알고리즘을 고려하라고 하였으므로, 두 수의 합을 찾는 문제이므로 해시맵을 사용하여 O(n) 시간 복잡도로 해결할 수 있습니다.

var twoSum = function (nums, target) {
  const numMap = new Map();

  for (let i = 0; i < nums.length; i++) {
    const complement = target - nums[i];
    if (numMap.has(complement)) {
      return [numMap.get(complement), i];
    }
    numMap.set(nums[i], i);
  }

  return [];
};
