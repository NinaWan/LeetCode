public class Solution {
    public int arrangeCoins(int n) {
        int result = 0;
        long sum = 0;

        while (sum <= n) {
            result++;
            sum += result;
        }

        return result - 1;
    }
}