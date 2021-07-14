class Solution {
    private Map<Integer, List<Integer>> map;
    private Random random;

    public Solution(int[] nums) {
        this.random = new Random();
        this.map = new HashMap();

        for (int i = 0; i < nums.length; i++) {
            this.map.computeIfAbsent(nums[i], x -> new ArrayList()).add(i);
        }
    }

    public int pick(int target) {
        List<Integer> idxes = map.get(target);
        return idxes.get(random.nextInt(idxes.size()));
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */