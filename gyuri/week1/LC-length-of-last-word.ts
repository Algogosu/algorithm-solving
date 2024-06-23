function lengthOfLastWord(s: string): number {
  return s
    .split(" ")
    .filter((str) => str.length)
    .pop().length;
}
