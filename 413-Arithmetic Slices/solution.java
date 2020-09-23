class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if (A.length < 3) {
            return 0;
        }

        int ans = 0;
        int left = 0, right = 1, diff = 0;
        while (right < A.length) {
            diff = A[right] - A[left];

            while (right < A.length && A[right] - A[right - 1] == diff) {
                right++;
            }

            if (right - left >= 3) {
                int n = right - left;
                ans += n * (n - 3) / 2 + 1;
            }

            left = right - 1;
        }

        return ans;
    }
}