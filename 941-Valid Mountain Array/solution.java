class Solution {
    public boolean validMountainArray(int[] A) {
        if (A == null || A.length < 3) {
            return false;
        }

        int i = 0;
        while (i < A.length - 1 && A[i] < A[i + 1]) {
            i++;
        }

        if (i == A.length - 1 || i == 0) {
            return false;
        }

        while (i < A.length - 1 && A[i] > A[i + 1]) {
            i++;
        }

        return i == A.length - 1;
    }
}