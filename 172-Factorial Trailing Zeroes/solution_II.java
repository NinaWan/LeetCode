class Solution {
    public int trailingZeroes(int n) {
        // just count how many 5 in product factors
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }
}