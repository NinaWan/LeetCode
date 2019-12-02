class Solution {
    public int thirdMax(int[] nums) {
        Integer first = null;
        Integer second = null;
        Integer third = null;

        if (nums.length < 3) {
            return nums.length == 1 ? nums[0] : Math.max(nums[0], nums[1]);
        }

        for (int num : nums) {
            if (first == null || num > first) {
                third = second;
                second = first;
                first = num;
            } else if (num < first && (second == null || num > second)) {
                third = second;
                second = num;
            } else if (second != null && num < second && (third == null || num > third)) {
                third = num;
            }
        }

        return third == null ? second == null ? first : Math.max(first, second) : third;
    }
}