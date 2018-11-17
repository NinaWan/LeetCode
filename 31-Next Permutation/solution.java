class Solution {
    public void nextPermutation(int[] nums) {
        if (nums.length < 2) {
            return;
        }

        int curr = nums[nums.length - 1];

        for (int i = nums.length - 1; i > 0; i--) {
            int pre = nums[i - 1];

            if (curr > pre) {
                int j = i;
                for (; j < nums.length; j++) {
                    if (pre < nums[j]) {
                        break;
                    }
                }
                nums[i - 1] = nums[j];
                nums[j] = pre;
                break;
            } else {
                curr = pre;
                insertIntoSortedNums(i - 1, nums);
            }
        }
    }

    private void insertIntoSortedNums(int start, int[] sortedNums) {
        int greater;
        for (int i = start; i < sortedNums.length - 1; i++) {
            if (sortedNums[i] > sortedNums[i + 1]) {
                greater = sortedNums[i];
                sortedNums[i] = sortedNums[i + 1];
                sortedNums[i + 1] = greater;
            } else {
                break;
            }
        }
    }
}