class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};// up down left right
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>((a, b) -> a[2] - b[2]);// sort by the depth of water ascending
        queue.offer(new int[] {0, 0, grid[0][0]});

        while (!queue.isEmpty()) {
            int[] last = queue.poll();
            int i = last[0], j = last[1], depth = last[2];
            for (int[] dir : dirs) {
                int newI = i + dir[0], newJ = j + dir[1];
                if (newI < 0 || newI >= n || newJ < 0 || newJ >= n || visited[newI][newJ]) {
                    continue;
                }

                int maxDepth = Math.max(depth, grid[newI][newJ]);
                if (newI == n - 1 && newJ == n - 1) {
                    return maxDepth;
                }
                queue.offer(new int[] {newI, newJ, maxDepth});
                visited[newI][newJ] = true;
            }
        }

        return 0;
    }
}