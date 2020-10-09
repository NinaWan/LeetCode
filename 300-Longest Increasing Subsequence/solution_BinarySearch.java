class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] lisLast = new int[nums.length];
        int len = 0;

        for (int num : nums) {
            int start = 0, end = len;
            while (start < end) {
                int mid = start + (end - start) / 2;
                if (lisLast[mid] < num) {// find the first position where value is equal or greater than current num
                    start = mid + 1;
                } else {
                    end = mid;
                }
            }
            lisLast[start] = num;
            if (start == len) {
                len++;
            }
        }

        return len;
    }
}