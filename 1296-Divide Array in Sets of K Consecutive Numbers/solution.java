class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        int n = nums.length;
        if (n % k != 0) {
            return false;
        }

        TreeMap<Integer, Integer> numCounts = new TreeMap();
        for (int num : nums) {
            numCounts.put(num, numCounts.getOrDefault(num, 0) + 1);
        }

        int count = 0;
        while (count < n) {
            int start = numCounts.firstKey();

            for (int i = 0; i < k; i++) {
                int expected = start + i;
                if (numCounts.get(expected) == null) {
                    return false;
                }

                int expectedCount = numCounts.get(expected) - 1;
                if (expectedCount == 0) {
                    numCounts.remove(expected);
                } else {
                    numCounts.put(expected, expectedCount);
                }

                count++;
            }
        }

        return true;
    }
}