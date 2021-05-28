class Solution {
    public int minCut(String s) {
        int n = s.length();
        int[] minCut = new int[n];
        boolean[][] isPalindrome = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            minCut[i] = i;
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (j + 1 > i - 1 || isPalindrome[j + 1][i - 1])) {
                    minCut[i] = j == 0 ? 0
                                       : Math.min(minCut[j - 1] + 1, minCut[i]);
                    isPalindrome[j][i] = true;
                }
            }
        }

        return minCut[n - 1];
    }
}