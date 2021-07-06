class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack();
        Arrays.fill(ans, -1);

        for (int i = 0; i < 2 * n; i++) {
            int idx = i % n;
            while (!stack.isEmpty() && nums[idx] > nums[stack.peek()]) {
                ans[stack.pop()] = nums[idx];
            }

            stack.push(idx);
        }

        return ans;
    }
}