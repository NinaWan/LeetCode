public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        for(int i=1;i<=nums.length;i++){
            result.add(i);
        }

        for(int num:nums){
            if(result.get(num-1) == num){
                result.set(num-1, 0);
            }
        }

        for(int i=0;i<nums.length;i++){
            nums[i] = result.get(i);
        }

        result.clear();

        for(int num:nums){
            if(num != 0) result.add(num);
        }

        return result;
    }
}