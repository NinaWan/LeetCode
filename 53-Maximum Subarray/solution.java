public class Solution {
    public int maxSubArray(int[] nums) {
        int[] maxSum = nums;
        int max = nums[0];

        for(int i=1; i<nums.length; i++){
            if(maxSum[i-1] > 0){
                maxSum[i] = maxSum[i-1] + nums[i];
            }
            if(max < maxSum[i]){
                max = maxSum[i];
            }
        }

        return max;
    }
}