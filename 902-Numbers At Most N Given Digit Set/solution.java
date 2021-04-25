class Solution {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        int ans = 0;
        String ns = String.valueOf(n);

        for (int i = 1; i < ns.length(); i++) {
            ans += Math.pow(digits.length, i);
        }

        for (int i = 0; i < ns.length(); i++) {
            boolean hasSameDigits = false;
            for (String digit : digits) {
                char d = digit.charAt(0);// digits provided
                char c = ns.charAt(i);// digits in n
                if (d < c) {
                    ans += Math.pow(digits.length, ns.length() - (i + 1));
                } else if (d == c) {
                    hasSameDigits = true;
                    break;
                }
            }
            if (!hasSameDigits) {
                return ans;
            }
        }

        return ans + 1;
    }
}