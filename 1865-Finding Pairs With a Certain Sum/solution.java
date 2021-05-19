class FindSumPairs {
    int[] nums1;
    int[] nums2;
    Map<Integer, Integer> freq2;

    public FindSumPairs(int[] nums1,
                        int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        freq2 = new HashMap();
        for (int num2 : nums2) {
            freq2.put(num2, freq2.getOrDefault(num2, 0) + 1);
        }
    }

    public void add(int index, int val) {
        int oldVal = nums2[index];
        freq2.put(oldVal, freq2.get(oldVal) - 1);
        nums2[index] += val;
        freq2.put(nums2[index], freq2.getOrDefault(nums2[index], 0) + 1);
    }

    public int count(int tot) {
        int res = 0;
        for (int num1 : nums1) {
            res += freq2.getOrDefault(tot - num1, 0);
        }
        return res;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */