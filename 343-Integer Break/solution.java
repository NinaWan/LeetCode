class Solution {
    public int integerBreak(int n) {
        if (n == 2 || n == 3) {
            return n - 1;
        }

        if (n % 3 == 0) {
            return (int) Math.pow(3, n / 3);
        }

        int count3 = (n - 2) / 3;
        int count2 = (n - 3 * count3) / 2;
        return (int) (Math.pow(3, count3) * Math.pow(2, count2));
    }
}