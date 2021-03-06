class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0 || target < matrix[0][0] ||
                target > matrix[matrix.length - 1][matrix[0].length - 1]) {
            return false;
        }

        int start = 0, end = matrix.length - 1, mid = start + (end - start) / 2;
        int row = 0;

        // find row
        while (start + 1 < end) {
            if (matrix[mid][0] == target) {
                return true;
            }

            if (matrix[mid][0] < target) {
                start = mid;
            } else {
                end = mid;
            }

            mid = start + (end - start) / 2;
        }

        if (matrix[start][0] >= target) {
            row = start - 1;
        }

        if (matrix[end][0] <= target) {
            row = end;
        } else {
            row = start;
        }

        // find column
        start = 0;
        end = matrix[0].length - 1;
        mid = start + (end - start) / 2;

        while (start + 1 < end) {
            if (matrix[row][mid] == target) {
                return true;
            }

            if (matrix[row][mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }

            mid = start + (end - start) / 2;
        }

        if (matrix[row][start] == target || matrix[row][end] == target) {
            return true;
        }

        return false;
    }
}