class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);// sort array in ascending order
        int max = nums[nums.length - 1];// max value in the array
        int min = nums[0];// min value in the array

        int[] frequencyBefore = new int[nums.length];// frequencyBefore[i] = times of the value appears before position i
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                frequencyBefore[i] = frequencyBefore[i - 1] + 1;
            }
        }

        int[] notOverDiffCount = new int[max * 2];// notOverDiffCount[i] = number of values that not greater than i, i will be in [0,max diff]
        int left = 0;
        for (int i = 0; i < notOverDiffCount.length; i++) {// note: array has been sorted at the beginning
            while (left < nums.length && nums[left] <= i) {
                left++;
            }
            notOverDiffCount[i] = left;
        }

        int start = 0, end = max - min;
        while (start < end) {// binary search to find out at which diff the total count of pairs is equal or first time over k
            int mid = start + (end - start) / 2;// mid represents the middle value of possible distances
            // calculate how many pairs that having distances less than or equal to mid
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                count += notOverDiffCount[nums[i] + mid] - notOverDiffCount[nums[i]] + frequencyBefore[i];
            }

            if (count >= k) {// when count==k, doesn't mean mid must be the answer, because number of pairs that having distance as mid may be zero
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }
}