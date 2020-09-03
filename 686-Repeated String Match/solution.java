class Solution {
    public int repeatedStringMatch(String a, String b) {
        int ans = 1;
        String s = a;

        while (s.length() < b.length()) {
            s += a;
            ans++;
        }

        if (s.indexOf(b) != -1) {
            return ans;
        }

        s += a;
        ans++;
        if (s.indexOf(b) != -1) {
            return ans;
        }

        return -1;
    }
}