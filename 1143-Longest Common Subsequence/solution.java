class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();

        int[][] lcs = new int[n1][n2];
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    lcs[i][j] = i != 0 && j != 0 ? lcs[i - 1][j - 1] + 1 : 1;
                } else {
                    int a = i == 0 ? 0 : lcs[i - 1][j];
                    int b = j == 0 ? 0 : lcs[i][j - 1];
                    lcs[i][j] = Math.max(a, b);
                }
            }
        }

        return lcs[n1 - 1][n2 - 1];
    }
}