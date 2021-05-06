class Solution {
    public boolean checkPartitioning(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], true);
        }
        for (int l = 1; l < n; l++) {
            for (int i = 0, j = i + l; i < n - l; i++, j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
            }
        }

        for (int i = 0; i < n - 2; i++) {// last index of prefix
            for (int j = i + 2; j < n; j++) {// first index of suffix
                if (dp[0][i] && dp[i + 1][j - 1] && dp[j][n - 1]) {
                    return true;
                }
            }
        }

        return false;
    }
}