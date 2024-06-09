const fs = require("fs");

// 입력을 파일로부터 읽어옵니다.
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

const N = parseInt(input[0]);
const friends = input.slice(1);

let maxFriends = 0;

for (let i = 0; i < N; i++) {
  const visited = new Array(N).fill(false);
  let count = 0;

  for (let j = 0; j < N; j++) {
    if (friends[i][j] === "Y") {
      if (!visited[j]) {
        visited[j] = true;
        count++;
      }

      for (let k = 0; k < N; k++) {
        if (friends[j][k] === "Y" && k !== i && !visited[k]) {
          visited[k] = true;
          count++;
        }
      }
    }
  }

  maxFriends = Math.max(maxFriends, count);
}

console.log(maxFriends);
