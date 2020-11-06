class Solution {
    public int maxPower(String s) {
        int ans = 1, curr = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                curr++;
                ans = Math.max(ans, curr);
            } else {
                curr = 1;
            }
        }

        return ans;
    }
}