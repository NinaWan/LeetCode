class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> nextGreater = new HashMap();
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < nums2.length; i++) {
            if (stack.isEmpty() || nums2[i] <= stack.peek()) {
                stack.push(nums2[i]);
                continue;
            }

            while (!stack.isEmpty() && nums2[i] > stack.peek()) {
                nextGreater.put(stack.pop(), nums2[i]);
            }

            stack.push(nums2[i]);
        }

        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = nextGreater.getOrDefault(nums1[i], -1);
        }

        return ans;
    }
}