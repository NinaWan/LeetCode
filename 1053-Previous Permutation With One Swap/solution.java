class Solution {
    public int[] prevPermOpt1(int[] A) {
        for (int i = A.length - 2; i >= 0; i--) {
            if (A[i] > A[i + 1]) {
                int j = i + 1;
                for (int m = i + 1; m < A.length; m++) {
                    if (A[m] > A[j] && A[m] < A[i]) {
                        j = m;
                    }
                }

                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
                return A;
            }
        }

        return A;
    }
}