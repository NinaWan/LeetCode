class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap();
        int[] ans = new int[k];
        List<List<Integer>> buckets = new ArrayList(nums.length + 1);

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        for (int i = 0; i <= nums.length; i++) {
            buckets.add(new ArrayList());
        }

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            buckets.get(entry.getValue()).add(entry.getKey());
        }

        int count = 0;
        for (int i = nums.length; i > 0 && count < k; i--) {
            if (!buckets.get(i).isEmpty()) {
                for (int num : buckets.get(i)) {
                    ans[count] = num;
                    count++;
                    if (count == k) {
                        break;
                    }
                }
            }
        }

        return ans;
    }
}