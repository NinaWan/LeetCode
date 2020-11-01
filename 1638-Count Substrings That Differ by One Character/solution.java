class Solution {
    public int countSubstrings(String s, String t) {
        int ans = 0;
        int m = s.length(), n = t.length();
        int[][] dps = new int[m + 1][n + 1], dpe = new int[m + 1][n + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    dpe[i + 1][j + 1] = dpe[i][j] + 1;
                }
            }
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (s.charAt(i) == t.charAt(j)) {
                    dps[i][j] = dps[i + 1][j + 1] + 1;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (s.charAt(i) != t.charAt(j)) {
                    ans += (dpe[i][j] + 1) * (dps[i + 1][j + 1] + 1);
                }
            }
        }

        return ans;
    }
}