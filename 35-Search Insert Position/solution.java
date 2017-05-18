public class Solution {
    public int searchInsert(int[] nums, int target) {
        int result = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == target){
                result = i;
                break;
            }
            if(nums[i]<target && ((i+1<nums.length && nums[i+1] > target) || i==nums.length-1)){
                result = i+1;
                break;
            }
        }
        return result;
    }
}