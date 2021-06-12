class Solution {

    public int numDecodings(String s) {
        if (s.charAt(0) == '0') {
            return 0;
        }

        int mod = (int) 1e9 + 7;
        long[] dp = new long[s.length() + 1];// dp[i] - number of all possible decode ways of substring s(0 : i-1)
        dp[0] = 1;
        dp[1] = s.charAt(0) == '*' ? 9
                                   : 1;
        for (int i = 2; i <= s.length(); i++) {
            char c1 = s.charAt(i - 2), c2 = s.charAt(i - 1);
            // one digit
            if (c2 == '*') {
                dp[i] += 9 * dp[i - 1];
            } else if (c2 != '0') {
                dp[i] += dp[i - 1];
            }

            // two digits
            if (c1 == '*') {
                if (c2 == '*') {
                    dp[i] += 15 * dp[i - 2];
                } else if (c2 <= '6') {
                    dp[i] += 2 * dp[i - 2];
                } else {
                    dp[i] += dp[i - 2];
                }
            } else if (c1 == '1' && c2 == '*') {
                dp[i] += 9 * dp[i - 2];
            } else if (c1 == '2' && c2 == '*') {
                dp[i] += 6 * dp[i - 2];
            } else if (c1 != '0' && c2 != '*' && 10 * (c1 - '0') + (c2 - '0') <= 26) {
                dp[i] += dp[i - 2];
            }

            dp[i] %= mod;
        }

        return (int) dp[s.length()];
    }
}