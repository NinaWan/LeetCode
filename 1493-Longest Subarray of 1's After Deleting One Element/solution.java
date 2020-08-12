class Solution {
    public int longestSubarray(int[] nums) {
        List<Integer> zeroIndex = new ArrayList();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroIndex.add(i);
            }
        }

        if (zeroIndex.size() == nums.length) {
            return 0;
        }

        if (zeroIndex.isEmpty()) {
            return nums.length - 1;
        }

        int result = 0;
        for (int i = 0; i < zeroIndex.size(); i++) {
            int left = 0;
            int right = 0;
            int curr = zeroIndex.get(i);

            if (curr != 0) {
                left = i == 0 ? curr : curr - zeroIndex.get(i - 1) - 1;
            }

            if (curr != nums.length - 1) {
                right = i == zeroIndex.size() - 1 ? nums.length - curr - 1 : zeroIndex.get(i + 1) - curr - 1;
            }

            result = Math.max(result, left + right);
        }

        return result;
    }
}