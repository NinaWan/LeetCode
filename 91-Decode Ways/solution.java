class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;

        for (int i = 0; i < s.length(); i++) {
            if (i == 0) {
                dp[i + 1] = s.charAt(i) == '0' ? 0 : 1;
            } else {
                dp[i + 1] = s.charAt(i) == '0' ? 0 : dp[i];

                int num = Integer.valueOf(s.substring(i - 1, i + 1));
                if (num < 27 && num > 0 && s.charAt(i - 1) != '0') {
                    dp[i + 1] += dp[i - 1];
                }
            }
        }

        return dp[s.length()];
    }
}