class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (null == matrix || matrix.length == 0) {
            return false;
        }

        int row = 0;

        while (row < matrix.length) {
            if (null == matrix[row] || matrix[row].length == 0) {
                row++;
                continue;
            }

            if (matrix[row][0] == target) {
                return true;
            }

            if (matrix[row][0] > target) {
                break;
            }

            int start = 0, end = matrix[row].length - 1;

            while (start + 1 < end) {
                int mid = start + (end - start) / 2;

                if (matrix[row][mid] == target) {
                    return true;
                }

                if (matrix[row][mid] < target) {
                    start = mid;
                } else {
                    end = mid;
                }
            }

            if (matrix[row][start] == target || matrix[row][end] == target) {
                return true;
            }

            row++;
        }

        return false;
    }
}