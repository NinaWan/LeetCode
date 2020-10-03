class Solution {
    public double nthPersonGetsNthSeat(int n) {
        return n == 1 ? 1 : 1.0 / n + ((double) (n - 2) / n) * nthPersonGetsNthSeat(n - 1);
    }
}