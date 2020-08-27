class Solution {
    public boolean queryString(String S, int N) {
        if (N > 2 * S.length()) {
            return false;
        }

        for (int i = N; i > 0; i--) {
            if (S.indexOf(Integer.toBinaryString(i)) == -1) {
                return false;
            }
        }

        return true;
    }
}