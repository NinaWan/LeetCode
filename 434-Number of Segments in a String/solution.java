class Solution {
    public int countSegments(String s) {
        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ((i != 0 && !Character.isWhitespace(s.charAt(i - 1)) && Character.isWhitespace(c)) || (i == s.length() - 1 && !Character.isWhitespace(c))) {
                ans++;
            }
        }

        return ans;
    }
}