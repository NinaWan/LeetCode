class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList();
        if (nums == null || nums.length < 2) {
            return new ArrayList<Integer>(result);
        }

        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i + 1 && nums[i] != nums[nums[i] - 1]) {
                int temp = nums[i];
                nums[i] = nums[nums[i] - 1];
                nums[temp - 1] = temp;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - 1 != i) {
                result.add(nums[i]);
            }
        }

        return result;
    }
}