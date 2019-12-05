class Solution {
    public int triangleNumber(int[] nums) {
        if (nums == null || nums.length < 3) {
            return 0;
        }

        Arrays.sort(nums);
        int result = 0;

        for (int a = 0; a < nums.length - 2; a++) {
            int c = a + 2;
            for (int b = a + 1; b < nums.length - 1; b++) {
                while (c < nums.length && nums[c] < nums[a] + nums[b]) {
                    c++;
                }

                result += Math.max(0, c - b - 1);
            }
        }

        return result;
    }
}