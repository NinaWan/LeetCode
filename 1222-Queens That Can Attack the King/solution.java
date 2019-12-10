class Solution {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> result = new ArrayList();
        int[][] board = new int[8][8];
        for (int[] queen : queens) {
            board[queen[0]][queen[1]] = 1;
        }

        // up - row--
        for (int i = king[0] - 1; i >= 0; i--) {
            if (board[i][king[1]] == 1) {
                result.add(Arrays.asList(i, king[1]));
                break;
            }
        }

        // down - row++
        for (int i = king[0] + 1; i < 8; i++) {
            if (board[i][king[1]] == 1) {
                result.add(Arrays.asList(i, king[1]));
                break;
            }
        }

        // left - col--
        for (int i = king[1] - 1; i >= 0; i--) {
            if (board[king[0]][i] == 1) {
                result.add(Arrays.asList(king[0], i));
                break;
            }
        }

        // right - col++
        for (int i = king[1] + 1; i < 8; i++) {
            if (board[king[0]][i] == 1) {
                result.add(Arrays.asList(king[0], i));
                break;
            }
        }

        // left up - row-- col--
        for (int i = king[0] - 1, j = king[1] - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                result.add(Arrays.asList(i, j));
                break;
            }
        }

        // left down - row++ col--
        for (int i = king[0] + 1, j = king[1] - 1; i < 8 && j >= 0; i++, j--) {
            if (board[i][j] == 1) {
                result.add(Arrays.asList(i, j));
                break;
            }
        }

        // right up - row-- col++
        for (int i = king[0] - 1, j = king[1] + 1; i >= 0 && j < 8; i--, j++) {
            if (board[i][j] == 1) {
                result.add(Arrays.asList(i, j));
                break;
            }
        }

        // right down - row++ col++
        for (int i = king[0] + 1, j = king[1] + 1; i < 8 && j < 8; i++, j++) {
            if (board[i][j] == 1) {
                result.add(Arrays.asList(i, j));
                break;
            }
        }

        return result;
    }
}