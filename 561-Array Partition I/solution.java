public class Solution {
    public int arrayPairSum(int[] nums) {
        // Null
        if (null == nums) return 0;

        Arrays.sort(nums);
        int result = 0;
        for (int i = 0; i < nums.length - 1; i += 2) {
            result += nums[i];
        }
        return result;
    }
}