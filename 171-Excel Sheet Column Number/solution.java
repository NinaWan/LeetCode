class Solution {
    public int titleToNumber(String s) {
        int ans = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            ans += (s.charAt(i) - 'A' + 1) * Math.pow(26, s.length() - 1 - i);
        }

        return ans;
    }
}