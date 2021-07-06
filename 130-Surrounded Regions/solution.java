class Solution {
    public void solve(char[][] board) {
        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int m = board.length, n = board[0].length;
        Queue<int[]> queue = new LinkedList();

        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                queue.offer(new int[] {i, 0});
                board[i][0] = '#';
            }

            if (board[i][n - 1] == 'O') {
                queue.offer(new int[] {i, n - 1});
                board[i][n - 1] = '#';
            }

            while (!queue.isEmpty()) {
                int[] cur = queue.poll();
                for (int[] dir : dirs) {
                    int x = cur[0] + dir[0];
                    int y = cur[1] + dir[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && board[x][y] == 'O') {
                        queue.offer(new int[] {x, y});
                        board[x][y] = '#';
                    }
                }
            }
        }

        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                queue.offer(new int[] {0, j});
                board[0][j] = '#';
            }

            if (board[m - 1][j] == 'O') {
                queue.offer(new int[] {m - 1, j});
                board[m - 1][j] = '#';
            }

            while (!queue.isEmpty()) {
                int[] cur = queue.poll();
                for (int[] dir : dirs) {
                    int x = cur[0] + dir[0];
                    int y = cur[1] + dir[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && board[x][y] == 'O') {
                        queue.offer(new int[] {x, y});
                        board[x][y] = '#';
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }
}