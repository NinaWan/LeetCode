class Solution {
    public int peakIndexInMountainArray(int[] A) {
        int start = 0, end = A.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            if (A[mid - 1] < A[mid] && A[mid] > A[mid + 1]) {
                return mid;
            }

            if (A[mid - 1] > A[mid]) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (A[start - 1] < A[start] && A[start] < A[start + 1]) {
            return start;
        } else {
            return end;
        }
    }
}