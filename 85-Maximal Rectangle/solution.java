class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }

        int maxArea = 0;
        int rowNum = matrix.length;
        int colNum = matrix[0].length;
        int[] left = new int[colNum];
        int[] right = new int[colNum];
        Arrays.fill(right, colNum);
        int[] height = new int[colNum];

        for (int i = 0; i < rowNum; i++) {
            // currLeft: the index for the first element of current consecutive 1s from left
            // currRight: the index for the first element of current consecutive 1s from right
            int currLeft = 0, currRight = colNum;

            // calculate left, from left to right
            for (int j = 0; j < colNum; j++) {
                if (matrix[i][j] == '1') {
                    left[j] = Math.max(currLeft, left[j]);
                } else {
                    left[j] = 0;
                    currLeft = j + 1;
                }
            }

            // calculate right, from right to left
            for (int j = colNum - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    right[j] = Math.min(currRight, right[j]);
                } else {
                    right[j] = colNum;
                    currRight = j;
                }
            }

            // calculate height
            for (int j = 0; j < colNum; j++) {
                if (matrix[i][j] == '1') {
                    height[j] += 1;
                } else {
                    height[j] = 0;
                }
            }

            // updat maxArea
            for (int j = 0; j < colNum; j++) {
                maxArea = Math.max(maxArea, (right[j] - left[j]) * height[j]);
            }
        }

        return maxArea;
    }
}