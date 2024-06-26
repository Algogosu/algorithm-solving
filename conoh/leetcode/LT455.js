function findContentChildren(g, s) {
  g.sort((a, b) => a - b);
  s.sort((a, b) => a - b);

  let childIndex = 0;
  let cookieIndex = 0;
  let contentChildren = 0;

  while (childIndex < g.length && cookieIndex < s.length) {
    if (s[cookieIndex] >= g[childIndex]) {
      contentChildren++;
      childIndex++;
    }

    cookieIndex++;
  }

  return contentChildren;
}
