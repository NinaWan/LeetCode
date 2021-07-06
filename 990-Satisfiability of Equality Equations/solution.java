class Solution {
    public boolean equationsPossible(String[] equations) {
        UnionFind uf = new UnionFind(26);

        for (String equation : equations) {
            if (equation.charAt(1) == '=') {
                uf.union(equation.charAt(0) - 'a', equation.charAt(3) - 'a');
            }
        }

        for (String equation : equations) {
            if (equation.charAt(1) == '!') {
                if (uf.connected(equation.charAt(0) - 'a', equation.charAt(3) - 'a')) {
                    return false;
                }
            }
        }
        return true;
    }

    public class UnionFind {
        private int[] parent;
        private int[] size;
        private int count;

        public UnionFind(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
            count = n;
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);

            if (rootP == rootQ) {
                return;
            }

            if (size[p] > size[q]) {
                parent[rootQ] = rootP;
                size[rootQ] += size[rootP];
            } else {
                parent[rootP] = rootQ;
                size[rootP] += size[rootQ];
            }

            count--;
        }

        public int find(int x) {
            while (parent[x] != x) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }

            return x;
        }

        public boolean connected(int p, int q) {
            return find(p) == find(q);
        }

        public int count() {
            return count;
        }
    }
}