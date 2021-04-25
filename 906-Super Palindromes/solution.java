class Solution {
    public int superpalindromesInRange(String left, String right) {
        int ans = 0;
        long l = Long.valueOf(left), r = Long.valueOf(right);

        // odd length
        for (int k = 1; k < 100000; k++) {
            String ks = String.valueOf(k);
            StringBuilder sb = new StringBuilder(ks);
            long value = Long.valueOf(ks + sb.reverse().toString().substring(1));
            long square = value * value;
            if (square > r) {
                break;
            }
            if (square >= l && isPalindrom(String.valueOf(square))) {
                ans++;
            }
        }

        // even length
        for (int k = 1; k < 100000; k++) {
            String ks = String.valueOf(k);
            StringBuilder sb = new StringBuilder(ks);
            long value = Long.valueOf(ks + sb.reverse().toString());
            long square = value * value;
            if (square > r) {
                break;
            }
            if (square >= l && isPalindrom(String.valueOf(square))) {
                ans++;
            }
        }

        return ans;
    }

    private boolean isPalindrom(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }

        return true;
    }
}