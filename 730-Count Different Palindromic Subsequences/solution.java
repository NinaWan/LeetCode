class Solution {
    public int countPalindromicSubsequences(String S) {
        int n = S.length();
        int mod = (int) 1e9 + 7;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        for (int k = 1; k < n; k++) {
            for (int i = 0, j = i + k; i < n - k; i++, j++) {
                if (S.charAt(i) != S.charAt(j)) {
                    dp[i][j] = dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1];
                } else {
                    int l = i + 1, r = j - 1;
                    char c = S.charAt(i);
                    while (l <= r && S.charAt(l) != c) {
                        l++;
                    }

                    while (l <= r && S.charAt(r) != c) {
                        r--;
                    }

                    if (l == r) {// one duplicate c
                        dp[i][j] = dp[i + 1][j - 1] * 2 + 1;
                    } else if (l > r) {// no duplicate c
                        dp[i][j] = dp[i + 1][j - 1] * 2 + 2;
                    } else {// more than one duplicate c
                        dp[i][j] = dp[i + 1][j - 1] * 2 - dp[l + 1][r - 1];
                    }
                }

                dp[i][j] = (int) (((long) dp[i][j] + mod) % mod);
            }
        }

        return dp[0][n - 1];
    }
}