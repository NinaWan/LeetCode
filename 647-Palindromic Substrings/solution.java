class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] isPalindromic = new boolean[n][n];
        int ans = 0;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= i; j--) {
                if (i == j || ((j == i + 1 || isPalindromic[i + 1][j - 1]) && s.charAt(i) == s.charAt(j))) {
                    isPalindromic[i][j] = true;
                    ans++;
                }
            }
        }

        return ans;
    }
}