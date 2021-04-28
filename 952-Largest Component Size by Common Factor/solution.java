class Solution {
    public int largestComponentSize(int[] A) {
        int n = A.length;
        UnionFind uf = new UnionFind(n);
        Map<Integer, Integer> indexMap = new HashMap<>();// key is the factor, val is the node index

        for (int i = 0; i < n; i++) {
            int a = A[i];
            for (int f1 = 2; f1 * f1 <= a; f1++) {
                if (a % f1 == 0) {
                    if (indexMap.containsKey(f1)) {
                        uf.union(i, indexMap.get(f1));
                    } else {
                        indexMap.put(f1, i);
                    }

                    int f2 = a / f1;
                    if (indexMap.containsKey(f2)) {
                        uf.union(i, indexMap.get(f2));
                    } else {
                        indexMap.put(f2, i);
                    }
                }
            }

            if (indexMap.containsKey(a)) {
                uf.union(i, indexMap.get(a));
            } else {
                indexMap.put(a, i);
            }
        }

        return uf.max;
    }

    private class UnionFind {
        private int[] parent;
        private int[] size;
        private int max;

        public UnionFind(int n) {
            parent = new int[n];
            size = new int[n];
            max = 1;

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
            if (rootX != rootY) {
                parent[rootX] = rootY;
                size[rootY] += size[rootX];
                max = Math.max(max, size[rootY]);
            }
        }
    }
}