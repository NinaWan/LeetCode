class Solution {
    public int[] getCoprimes(int[] nums, int[][] edges) {
        int n = nums.length;
        Map<Integer, List<Integer>> tree = new HashMap();// (node, list of neighbours)
        for (int[] edge : edges) {
            buildEdge(edge[0], edge[1], tree);
            buildEdge(edge[1], edge[0], tree);
        }

        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        // pathMap -> (val, [{node, depth},...])
        dfs(0, new HashSet(), 0, ans, nums, new HashMap(), tree);

        return ans;
    }

    private void dfs(int node, Set<Integer> visited, int depth, int[] ans, int[] nums, Map<Integer, List<int[]>> pathMap,
            Map<Integer, List<Integer>> tree) {
        if (visited.contains(node)) {
            return;
        }

        visited.add(node);

        int largestDepth = -1;
        for (int i = 0; i < 51; i++) {
            if (gcd(nums[node], i) == 1 && pathMap.containsKey(i) && pathMap.get(i).size() > 0) {
                List<int[]> path = pathMap.get(i);
                int[] top = path.get(path.size() - 1);
                if (largestDepth < top[1]) {
                    largestDepth = top[1];
                    ans[node] = top[0];
                }
            }
        }

        List<int[]> list = pathMap.getOrDefault(nums[node], new ArrayList());
        list.add(new int[] {node, depth});
        pathMap.put(nums[node], list);

        for (Integer nei : tree.getOrDefault(node, new ArrayList<Integer>())) {
            dfs(nei, visited, depth + 1, ans, nums, pathMap, tree);
        }

        List<int[]> path = pathMap.get(nums[node]);
        path.remove(path.size() - 1);
        pathMap.put(nums[node], path);
    }

    private int gcd(int a, int b) {
        return b == 0 ? a
                      : gcd(b, a % b);
    }

    private void buildEdge(int u, int v, Map<Integer, List<Integer>> tree) {
        List<Integer> list = tree.getOrDefault(u, new ArrayList());
        list.add(v);
        tree.put(u, list);
    }
}