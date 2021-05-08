class Solution {
    public int countHomogenous(String s) {
        long ans = 0;
        int mod = (int) 1e9 + 7;

        for (int i = 0, count = 0; i < s.length(); i++) {
            if (i == 0 || s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                ans += (long) count * (count + 1) / 2;
                ans %= mod;
                count = 1;
            }

            if (i == s.length() - 1) {
                ans += (long) count * (count + 1) / 2;
                ans %= mod;
            }
        }

        return (int) ans;
    }
}