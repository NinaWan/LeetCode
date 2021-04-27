class Solution {
    public int longestOnes(int[] A, int K) {
        int left = 0, right = 0, ans = 0;
        int count = A[0] == 0 ? 1
                              : 0;

        while (right < A.length) {
            if (count <= K) {
                ans = Math.max(ans, right - left + 1);
                right++;
                if (right < A.length && A[right] == 0) {
                    count++;
                }
            } else {
                if (A[left] == 0) {
                    count--;
                }
                left++;
            }
        }

        return ans;
    }
}