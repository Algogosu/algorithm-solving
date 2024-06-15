const [N, ...input] = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n")
  .map(Number);

// 메모리 초과
// let sum = 0;

// while (input.length !== 1) {
//   input.sort();
//   const minimumSum = input.shift() + input.shift();
//   input.push(minimumSum);
//   sum += minimumSum;
// }

// console.log(sum);

// GPT 도움 받아서 MinHeap 구현 ...
class MinHeap {
  constructor() {
    this.heap = [];
  }

  push(val) {
    this.heap.push(val);
    this.bubbleUp(this.heap.length - 1);
  }

  pop() {
    if (this.size() === 1) return this.heap.pop();
    const min = this.heap[0];
    this.heap[0] = this.heap.pop();
    this.bubbleDown(0);
    return min;
  }

  size() {
    return this.heap.length;
  }

  bubbleUp(index) {
    while (index > 0) {
      const parentIndex = Math.floor((index - 1) / 2);
      if (this.heap[parentIndex] <= this.heap[index]) break;
      [this.heap[parentIndex], this.heap[index]] = [
        this.heap[index],
        this.heap[parentIndex],
      ];
      index = parentIndex;
    }
  }

  bubbleDown(index) {
    const length = this.heap.length;
    while (true) {
      const leftChildIndex = 2 * index + 1;
      const rightChildIndex = 2 * index + 2;
      let smallest = index;

      if (
        leftChildIndex < length &&
        this.heap[leftChildIndex] < this.heap[smallest]
      ) {
        smallest = leftChildIndex;
      }

      if (
        rightChildIndex < length &&
        this.heap[rightChildIndex] < this.heap[smallest]
      ) {
        smallest = rightChildIndex;
      }

      if (smallest === index) break;

      [this.heap[index], this.heap[smallest]] = [
        this.heap[smallest],
        this.heap[index],
      ];
      index = smallest;
    }
  }
}

function minimumComparisons(cardPiles) {
  const heap = new MinHeap();
  for (const pile of cardPiles) {
    heap.push(pile);
  }

  let totalComparisons = 0;

  while (heap.size() > 1) {
    const first = heap.pop();
    const second = heap.pop();
    const sum = first + second;
    totalComparisons += sum;
    heap.push(sum);
  }

  return totalComparisons;
}

console.log(minimumComparisons(input));
