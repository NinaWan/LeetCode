class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }

        int maxArea = 0;
        int row = grid.length;
        int col = grid[0].length;
        Queue<int[]> queue = new LinkedList();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    // bfs
                    queue.offer(new int[] {i, j});
                    int currArea = 0;
                    while (!queue.isEmpty()) {
                        int[] currP = queue.poll();
                        int r = currP[0];
                        int c = currP[1];

                        if (r >= 0 && r < row && c >= 0 && c < col && grid[r][c] == 1) {
                            grid[r][c] = 0;
                            currArea++;
                            queue.offer(new int[] {r - 1, c});// up
                            queue.offer(new int[] {r + 1, c});// down
                            queue.offer(new int[] {r, c - 1});// left
                            queue.offer(new int[] {r, c + 1});// right
                        }
                    }

                    maxArea = Math.max(maxArea, currArea);
                }
            }
        }

        return maxArea;
    }
}