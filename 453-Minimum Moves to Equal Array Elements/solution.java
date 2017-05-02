import java.lang.Math;

public class Solution {
    public int minMoves(int[] nums) {
        if(nums.length < 2) return 0;
        if(nums.length == 2) return Math.abs(nums[0]-nums[1]);

        int min = Integer.MAX_VALUE;
        int sum = 0;

        for(int num:nums){
            sum += num;
            if(num < min){
                min = num;
            }
        }

        return sum - min*nums.length;
    }
}