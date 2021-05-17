class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int low = 1, high = (int) 1e9;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (maxOperations >= countOperation(nums, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private long countOperation(int[] nums, int maxNumOfBalls) {
        long res = 0;

        for (int num : nums) {
            res += (num - 1) / maxNumOfBalls;
        }

        return res;
    }
}