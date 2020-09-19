class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] ans = new int[2];
        long sum = 0;
        Set<Integer> set = new HashSet();

        for (int num : nums) {
            sum += num;
            if (ans[0] == 0 && set.contains(num)) {
                ans[0] = num;
            }
            set.add(num);
        }

        ans[1] = (int) ((long) nums.length * (nums.length + 1) / 2 - sum + ans[0]);

        return ans;
    }
}