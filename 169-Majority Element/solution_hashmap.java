class Solution {
    public int majorityElement(int[] nums) {
        int mid = nums.length / 2;
        Map<Integer, Integer> occurences = new HashMap();

        for (int num : nums) {
            int occurence = occurences.getOrDefault(num, 0) + 1;
            if (occurence > mid) {
                return num;
            } else {
                occurences.put(num, occurence);
            }
        }

        return nums[0];
    }
}