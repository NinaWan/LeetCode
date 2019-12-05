class Solution {
    public boolean circularArrayLoop(int[] nums) {
        if (nums == null || nums.length < 2) {
            return false;
        }

        for (int i = 0; i < nums.length; i++) {// start from index i
            int currIdx = i;
            int slow = getNextIdx(i, nums);
            int fast = getNextIdx(getNextIdx(i, nums), nums);

            if (nums[currIdx] == 0) {
                continue;
            }

            // Go through one path
            while (isNotSelfCycle(slow, nums) && isNotSelfCycle(fast, nums) && isSameSign(nums[slow], nums[getNextIdx(slow, nums)]) && isSameSign(nums[fast], nums[getNextIdx(fast, nums)])) {// while same direction
                if (slow == fast) {// cycle found
                    return true;
                }

                slow = getNextIdx(slow, nums);
                fast = getNextIdx(getNextIdx(fast, nums), nums);
            }

            while (currIdx != slow && nums[currIdx] != 0) {
                nums[currIdx] = 0;
                currIdx = getNextIdx(currIdx, nums);
            }
        }

        return false;
    }

    private boolean isSameSign(int num1, int num2) {// neither num1 nor num2 could be zero
        return (double) num1 / num2 > 0;
    }

    private int getNextIdx(int currIdx, int[] nums) {
        return currIdx + nums[currIdx] >= 0 ? (currIdx + nums[currIdx]) % nums.length : nums.length + (currIdx + nums[currIdx]) % nums.length;
    }

    private boolean isNotSelfCycle(int currIdx, int[] nums) {
        return currIdx != getNextIdx(currIdx, nums);
    }
}