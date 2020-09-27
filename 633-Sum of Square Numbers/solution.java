class Solution {
    public boolean judgeSquareSum(int c) {
        int n = (int) Math.sqrt(c);
        for (int i = 0; i <= n; i++) {
            if (Math.sqrt(c - i * i) % 1 == 0) {
                return true;
            }
        }
        return false;
    }
}