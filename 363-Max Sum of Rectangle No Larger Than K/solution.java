class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int row = matrix.length, col = matrix[0].length;
        int ans = Integer.MIN_VALUE;

        for (int l = 0; l < col; l++) {
            int[] sum = new int[row];
            for (int r = l; r < col; r++) {
                TreeSet<Integer> set = new TreeSet() {
                    {
                        add(0);
                    }
                };
                int colSum = 0;
                for (int i = 0; i < row; i++) {
                    sum[i] += matrix[i][r];// sum of row i from column l to column r
                    colSum += sum[i];
                    Integer exclude = set.ceiling(colSum - k);
                    if (exclude != null) {
                        ans = Math.max(ans, colSum - exclude);
                    }
                    set.add(colSum);
                }
            }
        }

        return ans;
    }
}