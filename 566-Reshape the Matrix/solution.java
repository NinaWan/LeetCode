class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (r == 0 || c == 0 || (nums.length * nums[0].length / r) / c != 1) {
            return nums;
        }

        int[][] result = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int num = i * c + j;
                result[i][j] = nums[num / nums[0].length][num % nums[0].length];
            }
        }

        return result;
    }
}