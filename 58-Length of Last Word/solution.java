class Solution {
    public int lengthOfLastWord(String s) {
        if (null == s || s.length() == 0) {
            return 0;
        }

        int l = s.length() - 1;
        int r = s.length() - 1;
        while (r >= 0) {
            if (s.charAt(r) != ' ') {
                break;
            }
            r--;
        }

        l = r;
        while (l >= 0) {
            if (s.charAt(l) == ' ') {
                break;
            }
            l--;
        }

        return r - l;
    }
}