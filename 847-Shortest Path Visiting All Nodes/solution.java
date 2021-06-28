class Solution {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        Queue<int[]> queue = new LinkedList();// <bitmask, last node, path length>
        Set<String> visited = new HashSet();// visited path

        for (int i = 0; i < n; i++) {
            int bitmask = 1 << i;
            visited.add(bitmask + ":" + i);
            queue.offer(new int[] {bitmask, i, 1});
        }

        while (!queue.isEmpty()) {
            int[] top = queue.poll();

            if (top[0] == (1 << n) - 1) {// all nodes are visited
                return top[2] - 1;
            }

            for (int v : graph[top[1]]) {
                int bm = top[0] | (1 << v);
                String path = bm + ":" + v;
                if (!visited.contains(path)) {
                    visited.add(path);
                    queue.offer(new int[] {bm, v, top[2] + 1});
                }
            }
        }

        return -1;
    }
}