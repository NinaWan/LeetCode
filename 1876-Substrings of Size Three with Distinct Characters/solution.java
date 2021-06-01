class Solution {
    public int countGoodSubstrings(String s) {
        int ans = 0;

        for (int i = 2; i < s.length(); i++) {
            char s1 = s.charAt(i - 2), s2 = s.charAt(i - 1), s3 = s.charAt(i);
            if (s1 != s2 && s1 != s3 && s2 != s3) {
                ans++;
            }
        }

        return ans;
    }
}