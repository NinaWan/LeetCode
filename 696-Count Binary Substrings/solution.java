class Solution {
    public int countBinarySubstrings(String s) {
        int ans = 0;
        int a = 0;
        int b = 0;
        char c = s.charAt(0);

        for (int i = 0; i < s.length(); ) {
            while (i < s.length() && s.charAt(i) == c) {
                a++;
                i++;
            }
            ans += Math.min(a, b);

            b = 0;
            while (i < s.length() && s.charAt(i) != c) {
                b++;
                i++;
            }
            ans += Math.min(a, b);

            a = 0;
        }

        return ans;
    }
}