class Solution {
    public int minDistance(String word1, String word2) {
        if (null == word1 || null == word2) {
            return 0;
        }

        int n1 = word1.length();
        int n2 = word2.length();

        if (n1 == 0 || n2 == 0) {
            return Math.max(n1, n2);
        }

        int[][] lcs = new int[n1][n2];

        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    lcs[i][j] = i != 0 && j != 0 ? lcs[i - 1][j - 1] + 1
                                                 : 1;
                } else {
                    int a = i == 0 ? 0
                                   : lcs[i - 1][j];
                    int b = j == 0 ? 0
                                   : lcs[i][j - 1];
                    lcs[i][j] = Math.max(a, b);
                }
            }
        }

        return n1 + n2 - 2 * lcs[n1 - 1][n2 - 1];
    }
}