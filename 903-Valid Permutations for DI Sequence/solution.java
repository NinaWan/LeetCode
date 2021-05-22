class Solution {
    public int numPermsDISequence(String s) {
        int n = s.length(), mod = (int) 1e9 + 7;
        long[][] dp = new long[n + 1][n + 1]; // (i, j) - the number of permutation of [0, i] satisfying DI-rule S.substr(0, i), and ending with digit
                                              // j.
        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {// [0, i]
            for (int j = 0; j <= n; j++) {// for each possible end digit
                if (s.charAt(i - 1) == 'D') {
                    for (int k = j; k < i; k++) {// since it's decreasing, the previous digit should be j<=k<i, since the number which >=j will be
                                                 // added by 1
                        dp[i][j] += dp[i - 1][k];
                    }
                } else {
                    for (int k = 0; k < j; k++) {// since it's increasing, the previous digit should be >j
                        dp[i][j] += dp[i - 1][k];
                    }
                }
                dp[i][j] %= mod;
            }
        }

        long res = 0;
        for (int j = 0; j <= n; j++) {
            res += dp[n][j];
            res %= mod;
        }

        return (int) res;
    }
}