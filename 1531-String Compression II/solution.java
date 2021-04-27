class Solution {
    public int getLengthOfOptimalCompression(String s, int k) {
        int n = s.length();
        int[][] dp = new int[n + 1][k + 1];

        // initialization
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        // state updating process
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                int del = 0;
                int ctn = 0;

                // include the character at current position
                for (int p = i; p > 0; p--) {
                    if (s.charAt(p - 1) != s.charAt(i - 1)) {
                        del++; // delete previous characters not equal to current position's character
                    } else {
                        ctn++;
                    }

                    if (j - del < 0) {
                        break;
                    }

                    int lor = ctn <= 1 ? 0
                                       : String.valueOf(ctn).length();
                    dp[i][j] = Math.min(dp[i][j], dp[p - 1][j - del] + 1 + lor);
                }

                // not include the character at current position
                if (j != 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
                }
            }
        }

        return dp[n][k];
    }
}