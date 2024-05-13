function simplifyPath(path: string): string {
  let stack = [];

  path
    .split("/")
    .filter((e) => e)
    .map((e) => {
      if (e === "..") {
        stack.pop();
      } else if (e !== ".") {
        stack.push(e);
      }
    });

  return "/" + stack.join("/");
}
