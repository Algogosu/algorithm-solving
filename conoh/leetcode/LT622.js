// 문제: 원형 큐 만들기

// 여기 Circular Queue를 구현하는 클래스가 있습니다. Circular Queue는 FIFO (First In First Out) 원칙에 따라 작동하는 선형 데이터 구조이며, 마지막 위치가 처음 위치와 연결되어 원형을 이룹니다. 이것은 "Ring Buffer"로도 불립니다.

// Circular Queue의 한 장점은 큐 앞부분의 공간을 활용할 수 있다는 것입니다. 일반적인 큐에서는 큐가 가득 차면 앞에 공간이 있더라도 다음 요소를 삽입할 수 없습니다. 그러나 Circular Queue를 사용하면 공간을 활용하여 새로운 값을 저장할 수 있습니다.

// MyCircularQueue 클래스를 구현하세요:

// MyCircularQueue(k) : 큐의 크기 k로 객체를 초기화합니다.
// int Front() : 큐에서 가장 앞에 있는 항목을 가져옵니다. 큐가 비어 있으면 -1을 반환합니다.
// int Rear() : 큐에서 마지막 항목을 가져옵니다. 큐가 비어 있으면 -1을 반환합니다.
// boolean enQueue(int value) : 원형 큐에 요소를 삽입합니다. 작업이 성공하면 true를 반환합니다.
// boolean deQueue() : 원형 큐에서 요소를 삭제합니다. 작업이 성공하면 true를 반환합니다.
// boolean isEmpty() : 원형 큐가 비어 있는지 확인합니다.
// boolean isFull() : 원형 큐가 가득 찼는지 확인합니다.
// 프로그래밍 언어에서 내장된 큐 데이터 구조를 사용하지 않고 문제를 해결해야 합니다.

// 제약 조건:

// 1 <= k <= 1000
// 0 <= value <= 1000
// enQueue, deQueue, Front, Rear, isEmpty 및 isFull에 최대 3000번의 호출이 이루어집니다.

class MyCircularQueue {
  constructor(k) {
    this.queue = new Array(k);
    this.capacity = k;
    this.front = 0;
    this.rear = -1;
    this.size = 0;
  }

  Front() {
    if (this.isEmpty()) return -1;
    return this.queue[this.front];
  }

  Rear() {
    if (this.isEmpty()) return -1;
    return this.queue[this.rear];
  }

  enQueue(value) {
    if (this.isFull()) return false;
    this.rear = (this.rear + 1) % this.capacity;
    this.queue[this.rear] = value;
    this.size++;
    return true;
  }

  deQueue() {
    if (this.isEmpty()) return false;
    this.front = (this.front + 1) % this.capacity;
    this.size--;
    return true;
  }

  isEmpty() {
    return this.size === 0;
  }

  isFull() {
    return this.size === this.capacity;
  }
}
