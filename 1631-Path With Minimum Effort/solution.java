class Solution {
    public int minimumEffortPath(int[][] heights) {
        int[][] dirs = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
        int low = 0, high = (int) 1e6;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (isReachable(heights, dirs, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private boolean isReachable(int[][] heights, int[][] dirs, int threshold) {
        return dfs(heights, 0, 0, new boolean[heights.length][heights[0].length], dirs, threshold);
    }

    private boolean dfs(int[][] heights, int row, int col, boolean[][] visited, int[][] dirs, int threshold) {
        int m = heights.length, n = heights[0].length;

        if (row == m - 1 && col == n - 1) {
            return true;
        }

        visited[row][col] = true;
        for (int[] dir : dirs) {
            int i = row + dir[0], j = col + dir[1];
            if (i < 0 || j < 0 || i >= m || j >= n || visited[i][j]) {
                continue;
            } else if (Math.abs(heights[i][j] - heights[row][col]) <= threshold && dfs(heights, i, j, visited, dirs, threshold)) {
                return true;
            }
        }

        return false;
    }
}