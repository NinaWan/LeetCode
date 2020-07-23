class Solution {
    public int[] getNoZeroIntegers(int n) {
        int[] result = new int[2];

        int carryOver = 0;
        String first = "";
        String second = "";
        char[] digits = String.valueOf(n).toCharArray();
        for (int i = digits.length - 1; i >= 0; i--) {
            int digit = digits[i] - '0' - carryOver;
            if (i == 0) {
                if (digit == 0) {
                    continue;
                }

                if (digit == 1) {
                    second = "1" + second;
                } else {
                    first = "1" + first;
                    second = String.valueOf(digit - 1) + second;
                }

                continue;
            }

            if (digit < 0) {
                digit = (digit + 10) % 10;
                first = "1" + first;
                second = String.valueOf(digit - 1) + second;
                carryOver = 1;
                continue;
            }

            if (digit == 0) {
                first = "1" + first;
                second = "9" + second;
                carryOver = 1;
                continue;
            }

            if (digit == 1) {
                first = "2" + first;
                second = "9" + second;
                carryOver = 1;
                continue;
            }

            first = "1" + first;
            second = String.valueOf(digit - 1) + second;
            carryOver = 0;
        }
        result[0] = Integer.valueOf(first);
        result[1] = Integer.valueOf(second);

        return result;
    }
}