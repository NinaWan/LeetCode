class Solution {
    public String mergeAlternately(String word1, String word2) {
        String ans = "";
        int m = word1.length(), n = word2.length();

        for (int i = 0; i < Math.min(m, n); i++) {
            ans += word1.charAt(i);
            ans += word2.charAt(i);
        }

        if (m > n) {
            ans += word1.substring(n);
        } else if (n > m) {
            ans += word2.substring(m);
        }

        return ans;
    }
}