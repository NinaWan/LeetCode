class Solution {
    public int numSpecial(int[][] mat) {
        int ans = 0;
        int m = mat.length;
        int n = mat[0].length;
        int[] rows = new int[m];
        int[] cols = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    rows[i]++;
                    cols[j]++;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            if (rows[i] != 1) {
                continue;
            }

            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1 && cols[j] == 1) {
                    ans++;
                }
            }
        }

        return ans;
    }
}