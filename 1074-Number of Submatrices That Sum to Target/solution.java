class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] rowSum = new int[row][col];
        int result = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (j == 0) {
                    rowSum[i][j] = matrix[i][j];
                    continue;
                }

                rowSum[i][j] = rowSum[i][j - 1] + matrix[i][j];
            }
        }

        for (int left = 0; left < col; left++) {
            for (int right = left; right < col; right++) {
                Map<Integer, Integer> sumCount = new HashMap();
                sumCount.put(0, 1);
                int currSum = 0;

                for (int r = 0; r < row; r++) {
                    currSum += rowSum[r][right] - (left > 0 ? rowSum[r][left - 1]
                                                            : 0);
                    result += sumCount.getOrDefault(currSum - target, 0);
                    sumCount.put(currSum, sumCount.getOrDefault(currSum, 0) + 1);
                }
            }
        }

        return result;
    }
}