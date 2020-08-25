class Solution {
    public String reverseOnlyLetters(String S) {
        int left = 0;
        int right = S.length() - 1;
        String ls = "";
        String rs = "";

        while (left <= right) {
            char lc = S.charAt(left);
            char rc = S.charAt(right);

            if (left == right) {
                ls += S.charAt(left);
                break;
            }

            while (!(lc >= 'a' && lc <= 'z') && !(lc >= 'A' && lc <= 'Z') && left <= right) {
                ls += lc;
                left++;
                if (left < S.length()) {
                    lc = S.charAt(left);
                }
            }

            while (!(rc >= 'a' && rc <= 'z') && !(rc >= 'A' && rc <= 'Z') && left <= right) {
                rs = rc + rs;
                right--;
                if (right >= 0) {
                    rc = S.charAt(right);
                }
            }

            if (left < right) {
                ls += rc;
                rs = lc + rs;
                left++;
                right--;
            }
        }

        return ls + rs;
    }
}