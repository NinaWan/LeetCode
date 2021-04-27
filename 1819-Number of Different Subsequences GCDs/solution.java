class Solution {
    public int countDifferentSubsequenceGCDs(int[] nums) {
        int[] factors = new int[200001];

        for (int num : nums) {
            for (int k = 1; k * k <= num; k++) {
                if (num % k == 0) {
                    int j = num / k;
                    factors[k] = gcd(factors[k], num);
                    factors[j] = gcd(factors[j], num);
                }
            }
        }

        int ans = 0;

        for (int i = 1; i < factors.length; i++) {
            if (factors[i] == i) {
                ans++;
            }
        }

        return ans;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a
                      : gcd(b, a % b);
    }
}