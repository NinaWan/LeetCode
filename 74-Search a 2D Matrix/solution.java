class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (null == matrix || matrix.length == 0) {
            return false;
        }

        int rowNumber = -1;

        // iterate first element in each rows to find the right row
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i].length == 0) {
                continue;
            }

            if (matrix[i][0] == target) {
                return true;
            }

            if (matrix[i][0] < target) {
                rowNumber = i;
            } else {
                break;
            }
        }

        if (rowNumber == -1) {
            return false;
        }

        // binary search
        int start = 0, end = matrix[rowNumber].length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            if (matrix[rowNumber][mid] == target) {
                return true;
            }

            if (matrix[rowNumber][mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (matrix[rowNumber][start] == target || matrix[rowNumber][end] == target) {
            return true;
        }

        return false;
    }
}