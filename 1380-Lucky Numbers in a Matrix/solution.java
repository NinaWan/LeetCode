class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> result = new ArrayList();
        int m = matrix.length;
        int n = matrix[0].length;
        int[] rowMin = new int[m];
        int[] colMax = new int[n];

        for (int r = 0; r < m; r++) {
            int min = Integer.MAX_VALUE;
            for (int c = 0; c < n; c++) {
                if (matrix[r][c] < min) {
                    min = matrix[r][c];
                    rowMin[r] = c;
                }
            }
        }

        for (int c = 0; c < n; c++) {
            int max = Integer.MIN_VALUE;
            for (int r = 0; r < m; r++) {
                if (matrix[r][c] > max) {
                    max = matrix[r][c];
                    colMax[c] = r;
                }
            }
        }

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (rowMin[r] == c && colMax[c] == r) {
                    result.add(matrix[r][c]);
                }
            }
        }

        return result;
    }
}