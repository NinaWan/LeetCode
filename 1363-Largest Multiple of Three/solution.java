class Solution {
    public String largestMultipleOfThree(int[] digits) {
        int sum = 0;
        int[] r1 = {1, 4, 7, 2, 5, 8}, r2 = {2, 5, 8, 1, 4, 7};
        int[] count = new int[10];
        for (int digit : digits) {
            sum += digit;
            count[digit]++;
        }

        while (sum % 3 != 0) {
            for (int r : sum % 3 == 1 ? r1
                                      : r2) {
                if (count[r] > 0) {
                    count[r]--;
                    sum -= r;
                    break;
                }
            }
        }

        String ans = "";
        for (int d = 9; d >= 0; d--) {
            for (int i = 0; i < count[d]; i++) {
                ans += d;
            }
        }

        return ans.length() > 0 && ans.charAt(0) == '0' ? "0"
                                                        : ans;
    }
}