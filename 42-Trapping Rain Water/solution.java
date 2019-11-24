class Solution {
    public int trap(int[] height) {
        int result = 0;
        Stack<Integer> stack = new Stack();

        for (int i = 0; i < height.length; i++) {
            int currHeight = height[i];

            while (!stack.isEmpty() && currHeight > height[stack.peek()]) {
                int topIndex = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }

                int preIndex = stack.peek();
                int width = i - preIndex - 1;
                int boundedHeight = Math.min(height[preIndex], currHeight) - height[topIndex];
                result += width * boundedHeight;
            }

            stack.push(i);
        }

        return result;
    }
}