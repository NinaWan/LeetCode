class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        int ans = 1;
        int product = 1;

        for (int i = 1; i <= n; i++) {
            product *= i == 1 ? 9
                              : 11 - i;
            ans += product;
        }

        return ans;
    }
}