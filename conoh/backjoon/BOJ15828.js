let input = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n");

function solution(N, packets) {
  const buffer = [];

  for (let i = 1; i < packets.length; i++) {
    const packet = parseInt(packets[i]);

    if (packet === -1) break; // 입력의 끝

    if (packet === 0) {
      // 패킷 처리
      if (buffer.length > 0) buffer.shift(); // 버퍼에서 처리된 패킷 제거
    } else {
      // 패킷 추가
      if (buffer.length < N) buffer.push(packet); // 버퍼에 추가 가능한 경우에만 추가
    }
  }

  return buffer.length > 0 ? buffer.join(" ") : "empty"; // 남아있는 패킷 출력
}

const N = parseInt(input[0]);
const packets = input.slice(1);
const result = solution(N, packets);
console.log(result);
