class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

        int max = 0;
        int left = 0;
        int right = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
            if (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
            }
        }

        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (i == j || (s.charAt(i) == s.charAt(j) && (i == s.length() - 1 || dp[i + 1][j - 1]))) {
                    dp[i][j] = true;
                }

                if (dp[i][j] && (j - i + 1) > max) {
                    max = j - i + 1;
                    left = i;
                    right = j;
                }
            }
        }

        return s.substring(left, right + 1);
    }
}