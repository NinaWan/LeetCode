class Solution {
    public int sumSubseqWidths(int[] A) {
        long result = 0;
        long divisor = (long) Math.pow(10, 9) + 7;
        long comb = 1;

        Arrays.sort(A);

        for (int i = 0; i < A.length; i++, comb = (comb << 1) % divisor) {// each left shift means mutiply 2 one time
            result += (A[i] - A[A.length - i - 1]) * comb;
            result = result % divisor;
        }

        return (int) ((result + divisor) % divisor);
    }
}