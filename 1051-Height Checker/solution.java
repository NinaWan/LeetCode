class Solution {
    public int heightChecker(int[] heights) {
        int result = 0;
        int[] ordered = Arrays.copyOf(heights, heights.length);

        Arrays.sort(ordered);

        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != ordered[i]) {
                result++;
            }
        }

        return result;
    }
}