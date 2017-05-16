public class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0;
        int sum2 = nums.length*(nums.length+1)/2;

        for(int num:nums){
            sum += num;
        }

        return sum2-sum;
    }
}