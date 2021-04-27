class Solution {
    public int longestValidParentheses(String s) {
        int result = 0;
        char[] chars = s.toCharArray();
        int[] dp = new int[s.length()];

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == ')') {
                    int index = i - 1 - dp[i - 1];
                    dp[i] = index < 0 || chars[index] == ')' ? 0
                                                             : dp[i - 1] + 2 + (index < 1 ? 0
                                                                                          : dp[index - 1]);
                } else {
                    dp[i] = i == 1 ? 2
                                   : dp[i - 2] + 2;
                }

                result = Math.max(result, dp[i]);
            }
        }

        return result;
    }
}