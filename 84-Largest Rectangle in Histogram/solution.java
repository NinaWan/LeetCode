class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }

        int maxArea = 0;
        Stack<Integer> stack = new Stack();

        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                int top = stack.pop();
                int width = stack.isEmpty() ? i
                                            : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, heights[top] * width);
            }

            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int top = stack.pop();
            int width = stack.isEmpty() ? heights.length
                                        : heights.length - 1 - stack.peek();
            maxArea = Math.max(maxArea, heights[top] * width);
        }

        return maxArea;
    }
}