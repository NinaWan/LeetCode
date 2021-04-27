class Solution {
    public int myAtoi(String str) {
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }

        char first = str.charAt(0);
        if (first == '-' || first == '+' || (first >= '0' && first <= '9')) {
            boolean isNegative = (first == '-');
            if (first == '-' || first == '+') {
                str = str.substring(1, str.length());
            }

            String num = "";
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                    break;
                }

                num += String.valueOf(str.charAt(i));
            }

            // remove leading zeros
            for (int i = 0; i < num.length(); i++) {
                if (i == num.length() - 1 && num.charAt(i) == '0') {
                    num = "";
                    break;
                }

                if (num.charAt(i) != '0') {
                    num = num.substring(i, num.length());
                    break;
                }
            }

            if (num.length() == 0) {
                return 0;
            }

            if (num.length() > 10) {
                return isNegative ? Integer.MIN_VALUE
                                  : Integer.MAX_VALUE;
            }

            long result = isNegative ? -Long.valueOf(num)
                                     : Long.valueOf(num);
            if (result >= Long.valueOf(Integer.MAX_VALUE) || result <= Long.valueOf(Integer.MIN_VALUE)) {
                return isNegative ? Integer.MIN_VALUE
                                  : Integer.MAX_VALUE;
            }

            return (int) result;
        }

        return 0;
    }
}