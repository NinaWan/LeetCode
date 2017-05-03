public class Solution {
    public int islandPerimeter(int[][] grid) {
        if(null == grid || 0 == grid.length) return 0;

        int result = 0;
        int row = grid.length;
        int col = grid[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j] == 1){
                    // Up
                    if(i == 0){
                        result++;
                    }else{
                        if(grid[i-1][j] == 0) result++;
                    }

                    // Down
                    if(i == row-1){
                        result++;
                    }else{
                        if(grid[i+1][j] == 0) result++;
                    }

                    // Left
                    if(j == 0){
                        result++;
                    }else{
                        if(grid[i][j-1] == 0) result++;
                    }

                    // Right
                    if(j == col-1){
                        result++;
                    }else{
                        if(grid[i][j+1] == 0) result++;
                    }
                }
            }
        }

        return result;
    }
}