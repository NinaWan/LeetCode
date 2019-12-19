class Solution {
    public int movesToChessboard(int[][] board) {
        if (isPossible(board)) {
            int[] firstCol = new int[board.length];
            for (int i = 0; i < board.length; i++) {
                firstCol[i] = board[i][0];
            }

            return getMinimumSwap(board[0]) + getMinimumSwap(firstCol);
        }

        return -1;
    }

    private boolean isPossible(int[][] board) {
        int N = board.length;
        int rowDiff = 0;
        int colDiff = 0;

        for (int i = 0; i < N; i++) {
            rowDiff = 0;
            colDiff = 0;
            for (int j = 0; j < N; j++) {
                if ((board[i][j] ^ board[i][0] ^ board[0][j] ^ board[0][0]) == 1) {
                    return false;
                }

                rowDiff += board[i][j] == 1 ? 1 : -1;
                colDiff += board[j][i] == 1 ? 1 : -1;
            }

            if (Math.abs(rowDiff) > 1 || Math.abs(colDiff) > 1) {
                return false;
            }
        }

        return true;
    }

    private int getMinimumSwap(int[] arr) {
        int result = -1;
        int swapCount1 = 0;
        int swapCount2 = 0;
        int zeroCount = 0;
        int desiredZero1 = 0;
        int desiredZero2 = 0;
        for (int i = 0; i < arr.length; i++) {
            int desired1 = i % 2; // start with 0
            int desired2 = 1 - i % 2; // start with 1

            swapCount1 += arr[i] != desired1 ? 1 : 0;
            swapCount2 += arr[i] != desired2 ? 1 : 0;
            zeroCount += arr[i] == 0 ? 1 : 0;
            desiredZero1 += 1 - desired1;
            desiredZero2 += 1 - desired2;
        }
        if (desiredZero1 == zeroCount) {
            result = result < 0 ? swapCount1 / 2 : Math.min(result, swapCount1 / 2);
        }
        if (desiredZero2 == zeroCount) {
            result = result < 0 ? swapCount2 / 2 : Math.min(result, swapCount2 / 2);
        }

        return result;
    }
}