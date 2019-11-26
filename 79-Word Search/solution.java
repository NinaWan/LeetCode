class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || word == null || word.length() == 0) {
            return false;
        }

        char[] letters = word.toCharArray();
        int[][] isVisited = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == letters[0]) {
                    isVisited[i][j] = 1;
                    if (dfs(board, i, j, letters, 1, isVisited)) {
                        return true;
                    }
                    isVisited[i][j] = 0;
                }
            }
        }

        return false;
    }

    public boolean dfs(char[][] board, int i, int j, char[] letters, int start, int[][] isVisited) {
        if (start >= letters.length) {
            return true;
        }

        boolean up = false;
        boolean down = false;
        boolean left = false;
        boolean right = false;

        if (i > 0 && board[i - 1][j] == letters[start] && isVisited[i - 1][j] == 0) {
            isVisited[i - 1][j] = 1;
            up = dfs(board, i - 1, j, letters, start + 1, isVisited);
            isVisited[i - 1][j] = 0;
        }

        if (!up && i < board.length - 1 && board[i + 1][j] == letters[start] && isVisited[i + 1][j] == 0) {
            isVisited[i + 1][j] = 1;
            down = dfs(board, i + 1, j, letters, start + 1, isVisited);
            isVisited[i + 1][j] = 0;
        }

        if (!up && !down && j > 0 && board[i][j - 1] == letters[start] && isVisited[i][j - 1] == 0) {
            isVisited[i][j - 1] = 1;
            left = dfs(board, i, j - 1, letters, start + 1, isVisited);
            isVisited[i][j - 1] = 0;
        }

        if (!up && !down && !left && j < board[0].length - 1 && board[i][j + 1] == letters[start] && isVisited[i][j + 1] == 0) {
            isVisited[i][j + 1] = 1;
            right = dfs(board, i, j + 1, letters, start + 1, isVisited);
            isVisited[i][j + 1] = 0;
        }

        return up || down || left || right;
    }
}