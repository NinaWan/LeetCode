class Solution {
    public boolean isMatch(String s, String p) {
        if (null == s || null == p || (p.length() == 0 && s.length() != 0)) {
            return false;
        }

        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[m][n] = true;

        for (int i = m; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {// note: will be false when the pattern is empty while the text is not
                if (p.charAt(j) == '*') {
                    dp[i][j] = (i == m && j == n - 1) ? true
                                                      : i == m ? dp[i][j + 1]
                                                               : dp[i][j + 1] || dp[i + 1][j + 1] || dp[i + 1][j];
                } else {
                    dp[i][j] = i == m ? false
                                      : ((s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') && dp[i + 1][j + 1]);
                }
            }
        }

        return dp[0][0];
    }
}