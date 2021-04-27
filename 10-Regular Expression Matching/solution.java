class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[m][n] = true;// if both are empty string, should return true

        for (int i = m; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {// note: if pattern is empty while the text is not, then should return false
                boolean isSingleMatch = i < m && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');// note: isSingleMatch should be false when the
                                                                                                    // text is empty while the pattern is not

                if (j < n - 1 && p.charAt(j + 1) == '*') {// if previous character of pattern is *
                    dp[i][j] = dp[i][j + 2] || (isSingleMatch && dp[i + 1][j]); // ith in text matches jth in pattern or ith in text matches (j+2)th
                                                                                // in pattern
                } else {// if previous character of pattern is not * or current character is the last one in the string
                    dp[i][j] = isSingleMatch && dp[i + 1][j + 1];
                }
            }
        }

        return dp[0][0];
    }
}