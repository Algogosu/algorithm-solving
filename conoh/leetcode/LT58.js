/* 주어진 문자열 s는 단어와 공백으로 구성되어 있습니다. 문자열에서 마지막 단어의 길이를 반환합니다.

 단어는 공백이 아닌 문자만으로 이루어진 최대 부분 문자열입니다.

예시:

입력: s = "Hello World"
출력: 5
설명: 마지막 단어는 "World"이며 길이는 5입니다.

입력: s = " fly me to the moon "
출력: 4
설명: 마지막 단어는 "moon"이며 길이는 4입니다.

입력: s = "luffy is still joyboy"
출력: 6
설명: 마지막 단어는 "joyboy"이며 길이는 6입니다.

제한 조건:

1 <= s.length <= 104
s는 영어 문자와 공백 ' '만 포함합니다.
s에는 최소한 하나의 단어가 있습니다.

*/

var lengthOfLastWord = function (s) {
  // 문자열 양 끝의 공백 제거
  s = s.trim();

  let length = 0;

  // 문자열 뒤에서부터 탐색하여 공백을 만날 때까지 길이를 측정
  for (let i = s.length - 1; i >= 0; i--) {
    if (s[i] === " ") {
      break;
    }
    length++;
  }

  return length;
};
