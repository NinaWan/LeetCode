class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int result = 0;
        int[] preSum = new int[n];
        preSum[0] = nums[0];

        for (int i = 1; i < n; i++) {
            preSum[i] = nums[i] + preSum[i - 1];
        }

        List<Integer> subSum = new ArrayList();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i == 0) {
                    subSum.add(preSum[j]);
                } else {
                    subSum.add(preSum[j] - preSum[i - 1]);
                }
            }
        }

        Collections.sort(subSum);

        for (int i = left - 1; i < right; i++) {
            result = (int) ((result + subSum.get(i)) % (1e9 + 7));
        }

        return result;
    }
}