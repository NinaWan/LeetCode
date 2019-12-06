class Solution {
    public int[][] imageSmoother(int[][] M) {
        int row = M.length;
        int col = M[0].length;

        int[][] result = new int[row][col];

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                int sum = M[r][c];
                int count = 1;

                if (r > 0) {
                    count++;
                    sum += M[r - 1][c];
                    if (c > 0) {
                        count++;
                        sum += M[r - 1][c - 1];
                    }
                    if (c < col - 1) {
                        count++;
                        sum += M[r - 1][c + 1];
                    }
                }

                if (r < row - 1) {
                    count++;
                    sum += M[r + 1][c];
                    if (c > 0) {
                        count++;
                        sum += M[r + 1][c - 1];
                    }
                    if (c < col - 1) {
                        count++;
                        sum += M[r + 1][c + 1];
                    }
                }

                if (c > 0) {
                    count++;
                    sum += M[r][c - 1];
                }
                if (c < col - 1) {
                    count++;
                    sum += M[r][c + 1];
                }

                result[r][c] = sum / count;
            }
        }

        return result;
    }
}