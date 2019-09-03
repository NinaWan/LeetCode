class Solution {
    public boolean isSubsequence(String s, String t) {
        if (null == s || null == t) {
            return false;
        }

        int sIndex = 0;
        int tIndex = 0;

        for (; sIndex < s.length(); sIndex++) {
            char sCurrent = s.charAt(sIndex);

            while (tIndex < t.length() && sCurrent != t.charAt(tIndex)) {
                tIndex++;
            }

            if (tIndex >= t.length()) {
                return false;
            }

            if (sCurrent == t.charAt(tIndex)) {
                tIndex++;
            }
        }

        return true;
    }
}