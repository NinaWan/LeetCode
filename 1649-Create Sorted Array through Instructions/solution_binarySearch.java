class Solution {
    public int createSortedArray(int[] instructions) {
        int mod = (int) 1e9 + 7, ans = 0;
        List<Integer> sorted = new ArrayList();

        for (int instruction : instructions) {
            // find the fisrt element which is greater than the insert element
            int firstGreater = findFirstGreater(sorted, instruction);
            // find the first element which is equal or greater than the insert element
            int firstEqualOrGreater = findFirstEqualOrGreater(sorted, instruction);
            ans = (ans + Math.min(sorted.size() - firstGreater, firstEqualOrGreater)) % mod;
            sorted.add(firstGreater, instruction);
        }

        return ans;
    }

    private int findFirstGreater(List<Integer> sorted, int target) {
        if (sorted.isEmpty()) {
            return 0;
        }

        int start = 0, end = sorted.size() - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (sorted.get(mid) <= target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return sorted.get(start) > target ? start
                                          : start + 1;
    }

    private int findFirstEqualOrGreater(List<Integer> sorted, int target) {
        if (sorted.isEmpty()) {
            return 0;
        }

        int start = 0, end = sorted.size() - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (sorted.get(mid) < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return sorted.get(start) >= target ? start
                                           : start + 1;
    }
}