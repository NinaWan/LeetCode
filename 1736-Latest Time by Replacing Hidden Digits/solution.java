class Solution {
    public String maximumTime(String time) {
        char[] digits = time.toCharArray();

        for (int i = 0; i < digits.length; i++) {
            if (digits[i] == '?') {
                if (i == 0) {
                    digits[i] = digits[1] <= '3' || digits[1] == '?' ? '2'
                                                                     : '1';
                } else if (i == 1) {
                    digits[i] = digits[i - 1] == '2' ? '3'
                                                     : '9';
                } else if (i == 3) {
                    digits[i] = '5';
                } else {
                    digits[i] = '9';
                }
            }
        }

        return new String(digits);
    }
}