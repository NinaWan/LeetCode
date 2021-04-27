class Solution {
    public int nextGreaterElement(int n) {
        char[] digits = String.valueOf(n).toCharArray();

        for (int i = digits.length - 1; i > 0; i--) {
            if (digits[i - 1] < digits[i]) {
                char tmp = digits[i - 1];
                for (int j = i; j < digits.length; j++) {
                    if (digits[j] <= tmp) {
                        digits[i - 1] = digits[j - 1];
                        digits[j - 1] = tmp;
                        break;
                    } else if (j == digits.length - 1) {
                        digits[i - 1] = digits[j];
                        digits[j] = tmp;
                    }
                }

                long ans = 0;
                for (int m = 0; m < i; m++) {
                    ans = 10 * ans + Character.getNumericValue(digits[m]);
                }
                for (int k = digits.length - 1; k >= i; k--) {
                    ans = 10 * ans + Character.getNumericValue(digits[k]);
                }

                return ans > Integer.MAX_VALUE ? -1
                                               : (int) ans;
            }
        }

        return -1;
    }
}