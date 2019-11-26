class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int rs = 0;
        int re = n - 1;
        int cs = 0;
        int ce = n - 1;
        int currVal = 1;

        while (rs <= re && cs <= ce) {
            // first row
            for (int c = cs; c <= ce; c++) {
                result[rs][c] = currVal;
                currVal++;
            }

            // last column
            for (int r = rs + 1; r <= re; r++) {
                result[r][ce] = currVal;
                currVal++;
            }

            if (rs < re || cs < ce) {
                // last row
                for (int c = ce - 1; c >= cs; c--) {
                    result[re][c] = currVal;
                    currVal++;
                }

                // first column
                for (int r = re - 1; r > rs; r--) {
                    result[r][cs] = currVal;
                    currVal++;
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