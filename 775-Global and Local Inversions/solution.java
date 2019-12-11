class Solution {
    public boolean isIdealPermutation(int[] A) {
        int max = A[0];
        for (int i = 1; i < A.length - 1; i++) {
            if (max > A[i + 1]) {
                return false;
            }

            max = Math.max(max, A[i]);
        }

        return true;
    }
}