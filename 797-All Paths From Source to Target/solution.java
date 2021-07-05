class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList();
        traverse(0, graph, ans, new ArrayList());

        return ans;
    }

    private void traverse(int s, int[][] graph, List<List<Integer>> res, List<Integer> path) {
        path.add(s);

        if (s == graph.length - 1) {
            res.add(new ArrayList(path));
            path.remove(path.size() - 1);
            return;
        }

        for (int v : graph[s]) {
            traverse(v, graph, res, path);
        }

        path.remove(path.size() - 1);
    }
}