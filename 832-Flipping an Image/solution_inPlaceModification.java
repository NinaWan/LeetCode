class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        for (int r = 0; r < A.length; r++) {
            int lc = 0;
            int rc = A[0].length - 1;
            while (lc <= rc) {
                if (lc == rc) {
                    A[r][lc] = 1 - A[r][lc];
                } else {
                    int temp = A[r][lc];
                    A[r][lc] = 1 - A[r][rc];
                    A[r][rc] = 1 - temp;
                }

                lc++;
                rc--;
            }
        }

        return A;
    }
}