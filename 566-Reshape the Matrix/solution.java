public class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        // Null or Empty or row/column greater than 1000
        // Check if 'reshape' operation is possible and legal
        // Assume each element would not be null
        if(null == nums || nums.length == 0 || r > 10000 || c >10000 || nums.length*nums[0].length != r*c) return nums;

        // Reshape matrix with given row and column numbers
        int[][] result = new int[r][c];
        int row = 0, column = 0;
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums[0].length;j++){
                if(column >= c){
                    row++;
                    column = 0;
                }
                result[row][column] = nums[i][j];
                column++;
            }
        }

        return result;
    }
}