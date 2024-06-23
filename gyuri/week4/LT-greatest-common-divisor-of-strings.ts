function gcdOfStrings(str1: string, str2: string): string {
  if (str1 + str2 !== str2 + str1) return "";
  let lengthOfPattern1 = str1.length;
  let lengthOfPattern2 = str2.length;
  while (lengthOfPattern2 !== 0) {
    let temp = lengthOfPattern2;
    lengthOfPattern2 = lengthOfPattern1 % lengthOfPattern2;
    lengthOfPattern1 = temp;
  }
  return str1.substring(0, lengthOfPattern1);
}
