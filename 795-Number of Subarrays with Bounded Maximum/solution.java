class Solution {
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        int result = 0;

        for (int i = 0; i < A.length; i++) {
            int left = i - 1;
            int right = i + 1;
            if (A[i] <= R && A[i] >= L) {
                while (left >= 0 && A[left] < A[i]) {
                    left--;
                }

                while (right < A.length && A[right] <= A[i]) {
                    right++;
                }

                result += (i - left) * (right - i);
            }

        }

        return result;
    }
}