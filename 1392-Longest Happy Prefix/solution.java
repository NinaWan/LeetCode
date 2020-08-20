class Solution {
    public String longestPrefix(String s) {
        int[] lps = new int[s.length()];
        int p = 0;// prefix last matching letter position

        for (int i = 1; i < s.length(); i++) {
            while (p > 0 && s.charAt(i) != s.charAt(p)) {
                p = lps[p - 1];
            }

            if (s.charAt(i) == s.charAt(p)) {
                lps[i] = p + 1;
                p++;
            }
        }

        return s.substring(0, lps[s.length() - 1]);
    }
}