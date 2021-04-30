class Solution {
    public int minimumLength(String s) {
        int n = s.length();
        int ans = n;

        for (int l = 0, r = n - 1; l < r;) {
            if (s.charAt(l) != s.charAt(r)) {
                break;
            }

            char c = s.charAt(l);
            while (l <= r && s.charAt(l) == c) {
                ans--;
                l++;
            }

            while (l < r && s.charAt(r) == c) {
                ans--;
                r--;
            }
        }

        return ans;
    }
}