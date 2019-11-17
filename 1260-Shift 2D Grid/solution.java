class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> result = new ArrayList();

        int rowNum = grid.length;
        int colNum = grid[0].length;
        int shift = k % (rowNum * colNum);

        for (int i = 0; i < rowNum; i++) {
            List<Integer> row = new ArrayList();

            for (int j = 0; j < colNum; j++) {
                int temp = (shift - j) % colNum == 0 ? (shift - j) / colNum - 1 : (shift - j) / colNum;
                int rowIndex = (shift - j) > 0 ? i - 1 - temp : i;
                int colIndex = j - shift % colNum;

                rowIndex = rowIndex < 0 ? rowIndex + rowNum : rowIndex;
                colIndex = colIndex < 0 ? colIndex + colNum : colIndex;
                row.add(grid[rowIndex][colIndex]);
            }

            result.add(row);
        }

        return result;
    }
}