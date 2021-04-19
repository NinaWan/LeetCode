class Solution {
    public int countDigitOne(int n) {
        long ans = 0;

        for (long divisor = 1; divisor <= n; divisor *= 10) {
            // i.e. 30141|5|92, when divisor=100, left=30141, right=92, curr=5
            long left = n / divisor / 10, right = n % divisor, curr = n / divisor % 10;
            if (curr == 0) {
                ans += left * divisor;
            } else if (curr == 1) {
                ans += left * divisor + right + 1;
            } else {
                ans += (left + 1) * divisor;
            }
        }

        return (int) ans;
    }
}