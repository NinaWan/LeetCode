public class Solution {
    public String[] findRelativeRanks(int[] nums) {
        String[] result = new String[nums.length];
        for(int i=0; i<nums.length; i++){
            int count = 0;
            for(int num:nums){
                if(nums[i] < num) count++;
            }
            switch(count){
                case 0: result[i] = "Gold Medal";
                    break;
                case 1: result[i] = "Silver Medal";
                    break;
                case 2: result[i] = "Bronze Medal";
                    break;
                default: result[i] = String.valueOf(count+1);
            }
        }
        return result;
    }
}