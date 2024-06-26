const allPathsSourceTarget = function (graph) {
  const target = graph.length - 1;
  const result = [];

  const dfs = (node, path) => {
    path.push(node);

    if (node === target) {
      result.push([...path]);
    } else {
      for (const neighbor of graph[node]) {
        dfs(neighbor, path);
      }
    }

    path.pop(); // 백트래킹
  };

  dfs(0, []);
  return result;
};
