class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList();
        if (matrix == null || matrix.length == 0) {
            return result;
        }

        int rs = 0;
        int re = matrix.length - 1;
        int cs = 0;
        int ce = matrix[0].length - 1;

        while (rs <= re && cs <= ce) {
            // first row
            for (int c = cs; c <= ce; c++) {
                result.add(matrix[rs][c]);
            }

            // last column
            for (int r = rs + 1; r <= re; r++) {
                result.add(matrix[r][ce]);
            }

            if (rs < re && cs < ce) {
                // last row
                for (int c = ce - 1; c >= cs; c--) {
                    result.add(matrix[re][c]);
                }

                // first column
                for (int r = re - 1; r > rs; r--) {
                    result.add(matrix[r][cs]);
                }
            }

            rs++;
            re--;
            cs++;
            ce--;
        }

        return result;
    }
}