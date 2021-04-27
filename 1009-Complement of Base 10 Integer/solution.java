class Solution {
    public int bitwiseComplement(int N) {
        if (N == 0) {
            return 1;
        }

        int quotient = N;
        int remainder = 0;
        int i = 0;
        int ans = 0;
        while (quotient != 0) {
            remainder = quotient % 2 == 0 ? 1
                                          : 0;
            ans += Math.pow(2, i) * remainder;
            quotient /= 2;
            i++;
        }

        return ans;
    }
}