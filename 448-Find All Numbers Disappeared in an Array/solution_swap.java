class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList();

        for (int i = 0; i < nums.length; i++) {
            while (nums[i] - 1 != i && nums[i] != nums[nums[i] - 1]) {
                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - 1 != i) {
                result.add(i + 1);
            }
        }

        return result;
    }
}