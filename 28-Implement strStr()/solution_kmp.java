class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }

        return new KMP(needle).search(haystack);
    }

    public class KMP {
        private String pat;
        private int[][] dp;

        public KMP(String pat) {
            this.pat = pat;
            this.dp = new int[pat.length()][26];

            dp[0][pat.charAt(0) - 'a'] = 1;
            int x = 0;
            for (int j = 1; j < pat.length(); j++) {
                int nextC = pat.charAt(j) - 'a';
                for (int c = 0; c < 26; c++) {
                    if (nextC == c) {
                        dp[j][c] = j + 1;
                    } else {
                        dp[j][c] = dp[x][c];
                    }
                }

                x = dp[x][nextC];
            }
        }

        public int search(String txt) {
            for (int i = 0, j = 0; i < txt.length(); i++) {
                j = dp[j][txt.charAt(i) - 'a'];// current state is j, next character is txt[i], find next state
                if (j == pat.length()) {// reach the final state
                    return i - pat.length() + 1;
                }
            }

            return -1;
        }
    }
}