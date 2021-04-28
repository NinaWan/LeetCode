class Solution {
    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
        List<Boolean> ans = new ArrayList();
        UnionFind uf = new UnionFind(n + 1);
        for (int d = 1; d <= n; d++) {
            for (int i = 2 * d; i <= n; i += d) {
                if (d > threshold) {
                    uf.union(d, i);
                }
            }
        }

        for (int[] query : queries) {
            ans.add(uf.find(query[0]) == uf.find(query[1]));
        }

        return ans;
    }

    private class UnionFind {
        private int[] parent;
        private int[] size;

        public UnionFind(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int x) {
            if (parent[x] == x) {
                return x;
            }

            return find(parent[x]);
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY) {
                return;
            }

            if (size[rootX] > size[rootY]) {
                parent[rootY] = rootX;
                size[rootX] += size[rootY];
            } else {
                parent[rootX] = rootY;
                size[rootY] += size[rootX];
            }
        }
    }
}