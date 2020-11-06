class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> ans = new ArrayList();
        List<Set<Integer>> neighbours = new ArrayList();
        int remaining = n;

        if (n == 1) {
            ans.add(n - 1);
            return ans;
        }

        for (int i = 0; i < n; i++) {
            neighbours.add(new HashSet());
        }

        for (int[] edge : edges) {
            neighbours.get(edge[0]).add(edge[1]);
            neighbours.get(edge[1]).add(edge[0]);
        }

        for (int i = 0; i < neighbours.size(); i++) {
            if (neighbours.get(i).size() == 1) {
                ans.add(i);
            }
        }

        while (remaining > 2) {
            List<Integer> leaves = new ArrayList();

            for (int leaf : ans) {
                remaining--;
                for (int neighbour : neighbours.get(leaf)) {
                    neighbours.get(neighbour).remove(leaf);
                    if (neighbours.get(neighbour).size() == 1) {
                        leaves.add(neighbour);
                    }
                }
            }

            ans = leaves;
        }

        return ans;
    }
}