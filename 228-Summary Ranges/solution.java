class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList();

        if (nums == null || nums.length == 0) {
            return result;
        }

        int leftVal = nums[0];

        for (int i = 0; i < nums.length; i++) {
            if ((i == nums.length - 1 || nums[i] + 1 != nums[i + 1])) {
                if (leftVal == nums[i]) {
                    result.add("" + leftVal);
                } else {
                    result.add(leftVal + "->" + nums[i]);
                }

                if (i != nums.length - 1) {
                    leftVal = nums[i + 1];
                }
            }
        }

        return result;
    }
}