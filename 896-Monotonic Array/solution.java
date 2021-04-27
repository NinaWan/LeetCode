class Solution {
    public boolean isMonotonic(int[] A) {
        int desc = 0;
        int asc = 0;
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i + 1] > A[i]) {
                asc++;
            }

            if (A[i + 1] < A[i]) {
                desc++;
            }
        }

        return desc != 0 && asc != 0 ? false
                                     : true;
    }
}