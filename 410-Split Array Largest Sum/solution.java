class Solution {
    public int splitArray(int[] nums, int m) {
        int sum = 0, max = 0;
        for (int num : nums) {
            sum += num;
            max = Math.max(max, num);
        }

        if (m == 1) {
            return sum;
        }

        int low = max, high = sum;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (isValid(nums, m, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private boolean isValid(int[] nums, int m, int target) {
        int sum = 0, count = 0;
        for (int num : nums) {
            if (sum + num > target) {
                sum = num;
                count++;
            } else {
                sum += num;
            }
        }

        return count < m ? true
                         : false;
    }
}