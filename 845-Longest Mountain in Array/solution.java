class Solution {
    public int longestMountain(int[] A) {
        if (A.length < 3) {
            return 0;
        }

        int ans = 0;
        int left = 0;
        int right = 0;

        while (left < A.length) {// find the first bottom
            if (left > A.length - 3) {
                return 0;
            }

            if (A[left] >= A[left + 1]) {
                left++;
            } else {
                break;
            }
        }

        right = left + 1;
        while (right < A.length) {
            if ((right == A.length - 1 && A[right - 1] > A[right]) || (right < A.length - 1 && A[right - 1] > A[right] && A[right] <= A[right + 1])) {
                ans = Math.max(ans, right - left + 1);
                left = right;
            } else if (A[right - 1] == A[right]) {
                left = right;
                while (left < A.length) {
                    if (left > A.length - 3) {
                        right = A.length;
                        break;
                    }

                    if (A[left] >= A[left + 1]) {
                        left++;
                        right = left;
                    } else {
                        break;
                    }
                }
            }

            right++;
        }

        return ans;
    }
}