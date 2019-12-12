class Solution {
    public int maxChunksToSorted(int[] arr) {
        int result = 0;

        int right = arr[0];
        for (int i = 0; i < arr.length; i++) {
            right = Math.max(right, arr[i]);

            if (right == i) {
                result++;
                right++;
            }
        }

        return result;
    }
}